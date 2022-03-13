$(document).ready(function () {
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


    let memId = $('#loginMember').val();
    let dataList, favBookIdList, lendBookIdList;
    $(document).on('click', '#sorting', function () {
        // 並び替え絞り込み用に、本のデータを全件クライアント側に保持
        getBookList(memId);
    });

    $(document).on('click', '#filtering', function () {
        // 並び替え絞り込み用に、本のデータを全件クライアント側に保持
        getBookList(memId);
    });

    // 非同期でbookListを取得
    function getBookList(memId) {
        $.ajax({
            url: 'api/getBookList',
            data: {memId: memId},
            type: 'get',
            success: function (response) {
                dataList = response.dataList;
                favBookIdList = response.myFavoriteBookIdList;
                lendBookIdList = response.myLendedBookIdList;
                // 読み込みが完了したらチェックボックスを活性化
                $('input[type="checkbox"]').prop('disabled', false);
            },
            error: function () {
            }
        });
    }

    /////////////////////////////////////////////////////////
    // 並び替えの処理
    ////////////////////////////////////////////////////////
    let sortCond;
    let editedList = null;
    $('input[name="sortCond"]').on('change', function () {
        sortCond = $(this).val();

        // 最新入荷日順
        if (sortCond === "1") {
            editedList = getSortedListLatest(dataList);
            // あいうえお順
        } else if (sortCond === "2") {
            editedList = getSortedListKana(dataList);
            // お気に入り数順
        } else if (sortCond === "3") {
            editedList = getSortedListFav(dataList);
            // 読まれた回数順
        } else if (sortCond === "4") {
            editedList = getSortedListLend(dataList);
        }
        // 要素を並び替え後のデータに入れ替え
        insertNewElement(editedList);
    });


    /////////////////////////////////////////////////////////
    // タグ絞り込みの処理
    ////////////////////////////////////////////////////////
    let filterCond;
    $('input[name="filterCond"]').on('change', function () {
        filterCond = $(this).val();

        // 資格
        if (filterCond === "1") {
            editedList = getFilteredList_1(dataList);
            // 入門書
        } else if (filterCond === "2") {
            editedList = getFilteredList_2(dataList);
            // WEB開発
        } else if (filterCond === "3") {
            editedList = getFilteredList_3(dataList);
            // 実用書
        } else if (filterCond === "4") {
            editedList = getFilteredList_4(dataList);
            // 娯楽
        } else if (filterCond === "5") {
            editedList = getFilteredList_5(dataList);
        }
        // 要素をタグで絞り込み後のデータに入れ替え
        insertNewElement(editedList);
    });
    /////////////////////////////////////////////////////////
    // 並び替え or タグで絞り込んだ要素に入れ替え
    ////////////////////////////////////////////////////////
    function insertNewElement (editedList) {
        // 元々の要素を削除
        $(`.book-list`).children().remove();
        // 並び替えた要素を全件追加する
        for (let i = 0; i < editedList.length; i++) {
            // url
            let destinationUrl = `/c4cbook/detail?bookId=${editedList[i]["bookId"]}`
            let memName = editedList[i]["memName"];

            let lendStatusObj;
            // memNameがnullの場合貸出可能
            if (memName === null) {
                lendStatusObj = `<div class="rent_able">貸出可能です</div>`
                // memNameがnullでない場合誰々に貸出中
            } else {
                lendStatusObj = `<div class="rent_disable">${memName}に貸出中</div>`
            }

            let bookId, elem1, elem2;
            bookId = editedList[i]["bookId"];
            // 読書済みの場合本が開いたアイコンを表示
            if (lendBookIdList.includes(bookId)) {
                elem1 = `<i class="fas fa-book-open fa-2x"></i>`
                // 読書済みでない場合本が開閉じたアイコンを表示
            } else {
                elem1 = `<i class="noread fas fa-book fa-2x"></i>`
            }
            // お気に入りしている場合赤いハートを表示
            if (favBookIdList.includes(bookId)) {
                elem2 = `<i class="fas fa-heart fa-2x" name="fav" data-id="${bookId}"></i>`
                // お気に入りしていない場合薄いピンクのハートを表示
            } else {
                elem2 = `<i class="noheart fas fa-heart fa-2x" name="fav" data-id="${bookId}"></i>`
            }

            // 挿入するタグを分割し、li要素に変換
            let tagIds, elemTag;
            tagIds = editedList[i]["tagIds"].split(",");
            elemTag = "";
            for (j = 0; j <tagIds.length; j++) {
                elemTag = elemTag + `<li>${tagIds[j]}</li>`
            }

            // 要素を追加
            $('.book-list').append(`
                    <div class="book_box">
						<div class="book_img_area">
							<a href="${destinationUrl}"><img class="book-img" src="data:image/jpeg;base64,${editedList[i]["encodedBookImg"]}" alt=""></a>
						</div>

						<div class="book_info">
							<div class="name"><a href="${destinationUrl}">${editedList[i]["title"]}</a></div>
							<div class="author">${editedList[i]["author"]}</div>
							${lendStatusObj}
							<ul class="tag">
								${elemTag}
							</ul>
							<div class="icon_img_wrap">
								<div class="icon_img_area">
                                    ${elem1}
								</div>
								<div class="icon_img_area book-count">${editedList[i]["lendCount"]}</div>
								<div class="icon_img_area">
									${elem2}
								</div>
								<div class="icon_img_area heart-count">
										${editedList[i]["favCount"]}
								</div>
							</div>
						</div>
                    </div>
		                `);
        }
    }

    /////////////////////////////////////////////////////////
    // 並び替えのメソッド
    ////////////////////////////////////////////////////////
    function getSortedListLatest(list) {
        let sortedList;
        sortedList = list.sort(function (a, b) {
            if (a.offerDate > b.offerDate) return -1;
            if (a.offerDate < b.offerDate) return 1;
            return 0;
        });
        return sortedList;
    }

    function getSortedListKana(list) {
        let sortedList;
        sortedList = list.sort(function (a, b) {
            if (a.titleKana < b.titleKana) return -1;
            if (a.titleKana > b.titleKana) return 1;
            return 0;
        });
        return sortedList;
    }

    function getSortedListFav(list) {
        let sortedList;
        sortedList = list.sort(function (a, b) {
            if (a.favCount > b.favCount) return -1;
            if (a.favCount < b.favCount) return 1;
            return 0;
        });
        return sortedList;
    }

    function getSortedListLend(list) {
        let sortedList;
        sortedList = list.sort(function (a, b) {
            if (a.lendCount > b.lendCount) return -1;
            if (a.lendCount < b.lendCount) return 1;
            return 0;
        });
        return sortedList;
    }

    /////////////////////////////////////////////////////////
    // タグ絞り込みのメソッド
    ////////////////////////////////////////////////////////
    function getFilteredList_1(list) {
        let filteredList = [];
        for (i = 0; i < list.length; i ++) {
            let tagIds = list[i]["tagIds"].split(",");
            if(tagIds.includes("資格")){
                filteredList.push(list[i]);
            }
        }
        return filteredList;
    }

    function getFilteredList_2(list) {
        let filteredList = [];
        for (i = 0; i < list.length; i ++) {
            let tagIds = list[i]["tagIds"].split(",");
            if(tagIds.includes("入門書")){
                filteredList.push(list[i]);
            }
        }
        return filteredList;
    }

    function getFilteredList_3(list) {
        let filteredList = [];
        for (i = 0; i < list.length; i ++) {
            let tagIds = list[i]["tagIds"].split(",");
            if(tagIds.includes("WEB開発")){
                filteredList.push(list[i]);
            }
        }
        return filteredList;
    }

    function getFilteredList_4(list) {
        let filteredList = [];
        for (i = 0; i < list.length; i ++) {
            let tagIds = list[i]["tagIds"].split(",");
            if(tagIds.includes("実用書")){
                filteredList.push(list[i]);
            }
        }
        return filteredList;
    }
    function getFilteredList_5(list) {
        let filteredList = [];
        for (i = 0; i < list.length; i ++) {
            let tagIds = list[i]["tagIds"].split(",");
            if(tagIds.includes("娯楽")){
                filteredList.push(list[i]);
            }
        }
        return filteredList;
    }

    // チェックボックスの選択制御
    $('input[type="checkbox"]').on("click", function () {
        $('input[type="checkbox"]').prop('checked', false);  //  全部のチェックを外す
        $(this).prop('checked', true);  //  押したやつだけチェックつける
    });

});
