$(document).ready(function() {
	// ハートをクリックした時
	$(document).on('click', 'i[name="fav"]', function () {
		let bookId = $(this).data('id');
		let memId = $("#loginMember").val();
		let heartCountElem = $(this).parent().parent().find('div.icon_img_area.heart-count');

		// お気に入り未の場合
		if ($(this).hasClass("noheart")) {
			$(this).removeClass("noheart");
			heartCountElem.text(parseInt(heartCountElem.text()) + 1);
			// お気に入り登録呼び出し　
			favorite(bookId, memId);
			// お気に入り済の場合
		} else {
			heartCountElem.text(parseInt(heartCountElem.text()) - 1);
			$(this).addClass("noheart");
			// お気に入り削除呼び出し
			delFavorite(bookId, memId);
		}
	})

	// POST Ajax お気に入り登録　
	function favorite(bookId, memId) {
		let formData = {
			bookId: bookId,
			memId: memId
		}
		$.ajax({
			url: 'api/favorite',
			type: 'post',
			contentType: "application/json",
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function (response) {
			},
			error: function () {
				alert("error");
			}
		});
	}

	// POST Ajax お気に入り削除
	function delFavorite(bookId, memId) {
		let formData = {
			bookId: bookId,
			memId: memId
		}
		$.ajax({
			url: 'api/favorite-delete',
			type: 'post',
			contentType: "application/json",
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function (response) {
			},
			error: function () {
				alert("error");
			}
		});
	}
	var bookId = $("#postBookId").val();
	//////////////////////////////////////////////////////////////////////
	// 新規貸出・予約登録
	//////////////////////////////////////////////////////////////////////
	// 貸出・予約カレンダー表示　GET 貸出履歴をAjaxで取得 呼び出し
	$(document).on('click', `#openLendingProcedureModal`, function() {
		$(`#openLendingProcedureModal`).prop('disabled', true);
		getLendHistorysByBookId();
	});

	// 日曜日
	$(document).on('click', 'td.fc-day-top.fc-sun', function() {
		selectedDateCheck($(this));
	});
	// 月曜日
	$(document).on('click', 'td.fc-day-top.fc-mon', function() {
		selectedDateCheck($(this));
	});
	// 火曜日
	$(document).on('click', 'td.fc-day-top.fc-tue', function() {
		selectedDateCheck($(this));
	});
	// 水曜日
	$(document).on('click', 'td.fc-day-top.fc-wed', function() {
		selectedDateCheck($(this));
	});
	// 木曜日
	$(document).on('click', 'td.fc-day-top.fc-thu', function() {
		selectedDateCheck($(this));
	});
	// 金曜日
	$(document).on('click', 'td.fc-day-top.fc-fri', function() {
		selectedDateCheck($(this));
	});
	// 土曜日
	$(document).on('click', 'td.fc-day-top.fc-sat', function() {
		selectedDateCheck($(this));
	});

	// POST Ajax 貸出・予約手続き 呼び出し
	$(document).on('click', `#save`, function() {
		saveLendReserve();
	});


	// 貸出・予約チェックボックスを自動で切り替え（新規登録用）
	// 貸出をチェックしたら
	$(document).on('click', '#lendChkBox', function() {
		if ($('#reserveChkBox').prop('checked') === true) {
			$('#reserveChkBox').prop('checked', false);
			$('#postLendStatus').val(11);
		} else {
			return false
		}
	});
	// 予約をチェックしたら
	$(document).on('click', '#reserveChkBox', function() {
		if ($('#lendChkBox').prop('checked') === true) {
			$('#lendChkBox').prop('checked', false);
			$('#postLendStatus').val(10);
		} else {
			return false
		}
	});

	// Hoverした日付の色を変える & pointer
	$(document).on('mouseenter', `div.fc-content-skeleton`, function() {
		$(this).css('cursor', 'pointer');
		hoverDate($(this).find('td.fc-day-top.fc-sun'));
		hoverDate($(this).find('td.fc-day-top.fc-mon'));
		hoverDate($(this).find('td.fc-day-top.fc-tue'));
		hoverDate($(this).find('td.fc-day-top.fc-wed'));
		hoverDate($(this).find('td.fc-day-top.fc-thu'));
		hoverDate($(this).find('td.fc-day-top.fc-fri'));
		hoverDate($(this).find('td.fc-day-top.fc-sat'));

	});

	//モーダルを閉じたら誰々に貸出中を初期化（削除）
	$(document).on('hidden.bs.modal', '#LendingProcedureModal', function() {
		$(`#showStatus`).empty();
	});

	//////////////////////////////////////////////////////////////////////
	// 貸出・予約ステータス更新（日付変更、返却、予約取消）
	//////////////////////////////////////////////////////////////////////
	// 予約取り消しボタンを押したら Ajax 予約取り消し　呼び出し
	$(document).on('click', `#cancelReserve`, function() {
		cancelReserve($(`#updateLendId`).val());
	});

	// 貸出・予約チェックボックスを自動で切り替え（更新用）
	// 貸出をチェックしたら
	$(document).on('click', '#updateLendChkBox', function() {
		if ($('#updateReserveChkBox').prop('checked') === true) {
			$('#updateReserveChkBox').prop('checked', false);
			$('#updateLendStatus').val(11);
		} else {
			return false
		}
	});
	// 予約をチェックしたら
	$(document).on('click', '#updateReserveChkBox', function() {
		if ($('#updateLendChkBox').prop('checked') === true) {
			$('#updateLendChkBox').prop('checked', false);
			$('#updateLendStatus').val(10);
		} else {
			return false
		}
	});

	// GET lendStatus更新（編集）
	$(document).on('click', `#update`, function() {
		lendHistoryUpdate();
	});
	// 返却ボタンを押したら Ajax ステータス19（返却）で更新
	$(document).on('click', `#returnBook`, function() {
		$("#updateLendStatus").val(19);
		lendHistoryUpdate();
	});

	//////////////////////////////////////////////////////////////////////
	// メソッド
	//////////////////////////////////////////////////////////////////////
	// 各曜日の要素から日付を取り出す
	let chkDateCount = 0;
	let fromDateObj, toDateObj;
	let alertMessage1 = "空いている日付を選択してください。";
	let alertMessage2 = "貸出日以降の日付を選択してください。";
	// 選択された日付のバリデーションチェック、赤くハイライト
	function selectedDateCheck(elem) {
		if (chkDateCount === 0) {
			$('thead *').removeAttr('style');
			$(`#postToDate`).val('');
			fromDateObj = pickDate(elem)
			if (lendHistoryDateList.includes(fromDateObj.selectedDate)) {
				alert(alertMessage1);
			} else {
				$(`#postFromDate`).val(fromDateObj.selectedDate);
				elem.css('background-color', 'red');
				chkDateCount++;
			}
		} else if (chkDateCount === 1) {
			toDateObj = pickDate(elem)
			let count = (toDateObj.selectedDateTime - fromDateObj.selectedDateTime) / 86400000;
			// 選択した期間をリストに格納
			let selectedDateList = [];
			for (i = 0; i <= count; i ++){
				selectedDateList.push(dateFormat(new Date(fromDateObj.selectedDateTime + (i * 86400000))));
			}
			// 貸出履歴の日付リストの中に、選択した期間リストの日付が含まれていたらtrue　
			var isContains = selectedDateList.some(el =>lendHistoryDateList.includes(el));
			// trueならその日付は選択できない
			if (isContains) {
				alert(alertMessage1);
			} else {
				if (toDateObj.selectedDateTime < fromDateObj.selectedDateTime) {
					alert(alertMessage2);
				} else {
					$(`#postToDate`).val(toDateObj.selectedDate);
					elem.css('background-color', 'red');
					chkDateCount = 0;
				}
			}
		}
	}

	// 日付の選択　（選択し日付と時間（ミリ秒）のobjectを返却）
	function pickDate(elem) {
		selectedDate = $(elem).data('date');
		selectedDateTime = new Date(selectedDate).getTime();
		let obj = {
			selectedDate: selectedDate,
			selectedDateTime: selectedDateTime,
		}
		return obj;
	}

	// dateformatメソッド
	function dateFormat(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		if (m < 10) { m = '0' + m; }
		if (d < 10) { d = '0' + d; }
		// フォーマット整形済みの文字列を戻り値にする
		return y + '-' + m + '-' + d;
	}

	// hoverした日付の色を変える
	function hoverDate(target) {
		target.hover(function() {
			// カーソルが当たった時の処理
			if ($(this).attr('style') == 'background-color: rgb(255, 0, 0);') {
				return false;
			} else {
				$(this).css("background-color", "#DCDCDC");
			}
		}, function() {
			// カーソルが離れた時の処理
			if ($(this).attr('style') == 'background-color: rgb(255, 0, 0);') {
				return false;
			} else {
				$(this).css("background-color", "");
			}
		});
	}

	// GET 貸出履歴をAjaxで取得
	let lendHistoryDateList = [];
	function getLendHistorysByBookId() {
		$.ajax({
			url: 'api/getLendHistory',
			type: 'get',
			data: `bookId=${bookId}`,
			success: function(response) {
				$(`#openLendingProcedureModal`).prop('disabled', false);
				$(`#LendingProcedureModal`).modal('show');
				$(`#isSomeoneLending`).val(0);
				$('#lendChkBox').prop('disabled', false);
				let lendHistorys = [];
				for (i = 0; i < response.data.length; i++) {
					// 貸出 or 予約ステータスのみ取得（返却ステータスはスキップ）
					if (response.data[i]["lendStatus"] == 19) {
						continue;
					} else {
						lendHistorys.push(response.data[i]);
					}
				}
				// カレンダーに表示させるイベントobjectのリスト
				let calendarEvents = [];

				// 返却されたresponseからカレンダーに渡すobjectを生成（calendarEvents）
				for (i = 0; i < lendHistorys.length; i++) {
					let title, fromDate, toDate, color, lendId, memId;
					fromDate = lendHistorys[i]["fromDate"];
					toDate = lendHistorys[i]["toDate"] + 86400000;
					lendId = lendHistorys[i]["lendId"];
					memId = lendHistorys[i]["memId"];

					// 貸出履歴の日付を全件保持（選択した日付が空いているか確認する用）
					for (j = 0; j < (toDate - fromDate) / 86400000; j++) {
						lendHistoryDateList.push(dateFormat(new Date(fromDate + (j * 86400000))));
					}
					// 誰かに貸出中の場合
					if (lendHistorys[i]["lendStatus"] == 11) {
						$(`#showStatus`).prepend(`
							<div class="recommended">${lendHistorys[i]["memName"]}さんに貸出中</div>
							`)
						title = `${lendHistorys[i]["memName"]} さんに貸出`;
						color = "#00ff00";
						$(`#isSomeoneLending`).val(1);
						// 誰かが予約中の場合
					} else if (lendHistorys[i]["lendStatus"] == 10) {
						title = `${lendHistorys[i]["memName"]} さんに貸出予定`;
						color = "#ffff00";
					}
					// カレンダーに表示させるobj
					let obj = {
						id: `lendId-${lendId},memId-${memId}`,
						title: title,
						start: dateFormat(new Date(fromDate)),
						end: dateFormat(new Date(toDate)),
						color: color,
						textColor: "black"
					};
					calendarEvents.push(obj);
					// 誰かに貸出中の場合は貸出をチェックできない
					if ($(`#isSomeoneLending`).val() == 1) {
						$('#lendChkBox').prop('disabled', true);
					}
				}

				// カレンダー生成 ///////////////////////////////////////
				// DOMを取得
				var calendarEl = document.getElementById('calendar');
				// 指定DOMにカレンダープラグインを適用する
				var calendar = new FullCalendar.Calendar(calendarEl, {
					locale: 'ja',
					header: {                                 // ヘッダーに表示する内容を指定します
				      left:   'title',                        // ヘッダーの左側に表示する物を指定
				      center: '',                             // ヘッダーの中央に表示する物を指定
				      right:  'prev,next'               // ヘッダーの左側に表示する物を指定
				    },
					plugins: ['dayGrid'],
					events: calendarEvents,
					eventClick: function(info) {
						let udLendId = parseInt(info.event.id.split(",")[0].split("-")[1]);
						let udMemId = parseInt(info.event.id.split(",")[1].split("-")[1]);
						let udFromDate = dateFormat(info.event.start);
						let udToDate = dateFormat(new Date(info.event.end.getTime() - 86400000));
						let udLendStatusColor = info.event.backgroundColor;
						let udLendStatus;
						// 自身のメンバーIDと一致するイベントのみ選択可能
						if (udMemId == $('#updateMemberId').val()) {
							$(`#myModal2`).modal('show');
						} else {
							alert("選択できません。");
						}
						$(document).on('shown.bs.modal', '#myModal2', function() {
							// チェックボックス初期化
							$('#updateLendChkBox').prop('disabled', false);
							$('#updateLendChkBox').prop('disabled', false);
							// 選択したイベントが予約ステータスの場合
							if (udLendStatusColor === "#ffff00") {
								// 誰かに貸出中の場合はステータスを貸出に変更できない
								if ($(`#isSomeoneLending`).val() == 1) {
									$('#updateLendChkBox').prop('disabled', true);
								}
								// 予約取消ボタンのみ表示
								$(`#cancelReserve`).removeClass('d-none');
								$(`#returnBook`).addClass('d-none');
								// 前の操作が残っていた場合初期化
								if ($('#updateLendChkBox').prop('checked', true)) {
									$('#updateLendChkBox').prop('checked', false);
								}
								// 予め予約にチェック
								$('#updateReserveChkBox').prop('checked', true);
								udLendStatus = 10;
								// 選択したイベントが貸出ステータスの場合
							} else if (udLendStatusColor == "#00ff00") {
								// 貸出の場合はステータス変更不可
								$('#updateLendChkBox').prop('disabled', true);
								$('#updateReserveChkBox').prop('disabled', true);
								// 返却ボタンのみ表示
								$(`#cancelReserve`).addClass('d-none');
								$(`#returnBook`).removeClass('d-none');
								// 前の操作が残っていた場合初期化
								if ($('#updateReserveChkBox').prop('checked', true)) {
									$('#updateReserveChkBox').prop('checked', false);
								}
								// 予め貸出にチェック
								$('#updateLendChkBox').prop('checked', true);
								udLendStatus = 11;
							}
							$(`#updateLendId`).val(udLendId);
							$(`#updateLendStatus`).val(udLendStatus);
							$(`#updateFromDate`).val(udFromDate);
							$(`#updateToDate`).val(udToDate);
						});

					}
				});
				calendar.render();
				$(document).on('hidden.bs.modal', `#LendingProcedureModal`, function() {
					calendar.destroy();
					calendarEvents = [];
					lendHistoryDateList = [];
				});
			},
			error: function() {
				alert("error");
				//　モーダルが閉じたらカレンダー情報を破棄
				$(`#LendingProcedureModal`).on('hidden.bs.modal', function() {
					calendar.destroy();
					calendarEvents = [];
					lendHistoryDateList = [];
				});
			}
		});
	}

	// POST Ajax 貸出・予約手続き
	function saveLendReserve() {
		var formData = {
			bookId: $("#postBookId").val(),
			memId: $("#postMemberId").val(),
			lendStatus: $("#postLendStatus").val(),
			fromDate: $("#postFromDate").val(),
			toDate: $("#postToDate").val()
		}
		if (!confirm('内容を確定しますか?')) {
			return false;
		} else {
			$.ajax({
				url: 'api/proceedLendReserve',
				type: 'post',
				contentType: "application/json",
				data: JSON.stringify(formData),
				dataType: 'json',
				success: function(response) {
					let fromDate = dateFormat(new Date(response.data.fromDate));
					let toDate = dateFormat(new Date(response.data.toDate));
					let status = response.data.lendStatus;
					let str;
					if (status == 11) {
						str = "貸出";
					} else if (status == 10) {
						str = "予約";
					}
					alert(`${str}手続きが完了しました。\r期間：${fromDate}〜${toDate}`);
					$(`#myModal2`).modal('hide');
					$('#LendingProcedureModal').modal('hide');
				},
				error: function() {
					alert("error");
					$(`#myModal2`).modal('hide');
					$('#LendingProcedureModal').modal('hide');
				}
			});
		}
	}

	// POST 貸出履歴をAjaxで更新
	function lendHistoryUpdate() {
		var formData = {
			lendId: $(`#updateLendId`).val(),
			bookId: $(`#updateBookId`).val(),
			lendStatus: $("#updateLendStatus").val(),
			fromDate: $("#updateFromDate").val(),
			toDate: $("#updateToDate").val()
		}
		let message;
		if (formData.lendStatus == 19) {
			message = "返却しますか？"
		} else {
			message = "内容を確定しますか？"
			if (new Date(formData.toDate).getTime() < new Date(formData.fromDate).getTime()) {
				alert("貸出日以降の日付を選択してください。");
				return false;
			}
		}
		if (!confirm(message)) {
			return false;
		} else {
			$.ajax({
				url: 'api/updateLendHistory',
				type: 'post',
				contentType: "application/json",
				data: JSON.stringify(formData),
				dataType: 'json',
				success: function(response) {
					alert(response.status);
					$(`#myModal2`).modal('hide');
					$('#LendingProcedureModal').modal('hide');

					if (response.data["lendStatus"] == 19) {
						$(`#reviewModal`).modal('show');
					}

					// 選択したMemIdをリストに保持
					let selectedValList = [];
					$(document).on('click','input[name="toMem"]', function(){
						let selectedId = $(this).val();
						if (selectedValList.includes(selectedId)){
							let index = selectedValList.indexOf(selectedId);
							selectedValList.splice(index,1);
						} else {
							if (selectedValList.length < 5){
								selectedValList.push(selectedId);
							} else {
								$(this).prop('checked', false);
								alert('5人以上は選択できません。');
							}
						}
					});

					let reviewLength = 0;
					$(document).on('input', '#reviewContent',function(){
						reviewLength = $(this).val().length;
						$('#reviewLength').text(reviewLength);
						if(1000 < reviewLength){
							$('#reviewLength').addClass('red');
						} else {
							$('#reviewLength').removeClass('red');
						}
					});

					$(`#sendReview`).on('click', function() {
						if (1000 < reviewLength){
							alert("レビューは1000文字以内で入力してください。")
						} else {
							if (!confirm('レビューを送信しますか')) {
								return false;
							} else {
								if (0 < selectedValList.length) {
									sendRecomendation(selectedValList);
								}
								if (reviewLength !== 0) {
									sendReview(response.data["lendId"]);
								}
								$(`#reviewModal`).modal('hide');
							}
						}
					});
				},
				error: function() {
					alert("error");
					$(`#myModal2`).modal('hide');
					$('#LendingProcedureModal').modal('hide');
				}
			});
		}
	}

	// POST Ajax 予約取り消し
	function cancelReserve(lendId) {
		if (!confirm('予約を取り消しますか?')) {
			return false;
		} else {
			$.ajax({
				url: 'api/cancelReserve',
				type: 'post',
				contentType: "application/json",
				data: JSON.stringify(lendId),
				dataType: 'json',
				success: function(response) {
					alert(response.status);
					$(`#myModal2`).modal('hide');
					$('#LendingProcedureModal').modal('hide');
				},
				error: function() {
					alert("error");
					$(`#myModal2`).modal('hide');
					$('#LendingProcedureModal').modal('hide');
				}
			});
		}
	}
	// POST Ajax おすすめ
	function sendRecomendation(selectedValList) {
		for (i = 0; i < selectedValList.length; i++) {
			let formData = {
				bookId: $(`#recomBookId`).val(),
				fromMemId: $("#fromMemberId").val(),
				toMemId: selectedValList[i],
			}
			$.ajax({
				url: 'api/sendRecomendation',
				type: 'post',
				contentType: "application/json",
				data: JSON.stringify(formData),
				dataType: 'json',
				success: function(response) {
					alert(response.status);
				},
				error: function() {
					alert("error");
				}
			});
		}
	}
	// POST Ajax レビュー送信
	function sendReview(lendId) {
		let formData = {
			lendId: lendId,
			review: $("#reviewContent").val(),
		}
		$.ajax({
			url: 'api/sendReview',
			type: 'post',
			contentType: "application/json",
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(response) {
				alert(response.status);
			},
			error: function() {
				alert("error");
			}
		});
	}

});

$('.review-contents').each(function(e){

    let $comment = $(this);
    // 元の文章を変数に格納
    let comment = $comment.html();
    let length = comment.length;
    let commentShow;
    let commentText;
    if($comment.height() > 50){
      // 文章の要素の高さが50を超えていたら隠す用のisHiddenクラスを付与
      $comment.addClass('isHidden');

      commentShow = comment.replace(/<br>/g, "\u00a0").substring(0, 68);
      commentText = commentShow += '<span class="review-contents-more">' + '... 続きを読む' + '</span>';
      $comment.html(commentText);

      // 続きを読むをクリックで元の文章を表示
      $comment.on('click', '.review-contents-more', function(e){
        let $anchor = $(e.currentTarget);
        let $anchorParent = $anchor.parent();
        $anchorParent.removeClass('isHidden');
        $anchorParent.html(''); // 一旦空にする
        $anchorParent.html(comment).append('<span class="review-contents-hide">' + '閉じる' + '</span>');
        // 閉じるをクリックで元に戻す
        $('.review-contents-hide').on('click', function(e){
          let $anchorHide = $(e.currentTarget).parent();
          $anchorHide.addClass('isHidden');
          $anchorHide.html('');
          $anchorHide.html(commentText);
        });
      });
    }
});

var listContents = $("#review-list-more li").length;
$("#review-list-more").each(function(){


    // 最初に表示させる数
    var Num = 3;

    // 最初はmoreボタン表示にし、
    $(this).find('#more-btn').show();
    $(this).find('#close-btn').hide();
    // 10行目まで表示
    $(this).find("li:not(:lt("+Num+"))").hide();

    // moreボタンがクリックされた時
    $('#more-btn').click(function(){
        // Numに+3ずつしていく = 3行ずつ追加する
        Num +=3;
        $(this).parent().find("li:lt("+Num+")").slideDown();

        // liの個数よりNumが多い時、
        if(listContents <= Num){
            Num = 3;// 「閉じる」がクリックされた後、表示させるアイテムの数
            gtNum = Num-1;
            $('#more-btn').hide();
            $('#close-btn').show();

            // 「閉じる」がクリックされたら、
            $('#close-btn').click(function(){
                $(this).parent().find("li:gt("+gtNum+")").slideUp();// 11行目以降は非表示にし、
                $(this).hide();// 閉じるボタンを非表示
                $('#more-btn').show();// moreボタン表示に
            });
        }
    });
});