function imgResize(){
 // ページ読み込み時に実行したい処理
 //////////画像の表示//////////
 //bookImgクラスのimgを取得
 var imgs = document.getElementsByClassName( "book-img");
 //reason_rejectsクラスを持つ要素の数を取得
 var i_imgs = imgs.length;
 //画像の元サイズ
 var src_width = 0;
 var src_height = 0;
 //変更先サイズ
 var tgt_width = 0;
 var tgt_height = 0;
 //表示位置決定用
 var disp_x = 0;
 var disp_y = 0;
 //px文字
 var px = "px";
 for (var i = 0;  i < i_imgs;  i++) {
  if ( imgs[i].complete ) {
   src_width = imgs[i].naturalWidth;

   src_height = imgs[i].naturalHeight;
   //縦長なら
   if ( src_width < src_height ) {
    //縦を200で固定して同じ縦横比で横を設定
    tgt_height = 200;
    tgt_width = 200 * (src_width / src_height);
    if ( tgt_width <= 150 ) {
     //設定した横が150以内あればその値で表示
     imgs[i].style.width = tgt_width + px;
     imgs[i].style.height = tgt_height + px;
     //中央に表示
     disp_x = (150 - tgt_width) / 2;
     disp_y = 0;
     imgs[i].style.left = disp_x + px;
     imgs[i].style.top = disp_y + px;
    } else {
     //設定した横が150以上あればその値からさらに縮小し表示
     tgt_width = 150;
     tgt_height = 150 * (src_height / src_width);
     imgs[i].style.width = tgt_width + px;
     imgs[i].style.height = tgt_height + px;
     //中央に表示
     disp_x = 0;
     disp_y = (150 - tgt_height) / 2;
     imgs[i].style.left = disp_x + px;
     imgs[i].style.top = disp_y + px;
    };
   //横長なら
   } else {
    //横を150で固定して同じ縦横比で縦を設定
    tgt_width = 150;
    tgt_height = 150 * (src_height / src_width);
    //横長の画像の場合はこの値で表示
    imgs[i].style.width = tgt_width + px;
    imgs[i].style.height = tgt_height + px;
    //中央に表示
    disp_x = 0;
    disp_y = (150 - tgt_height) / 2;
    imgs[i].style.left = disp_x + px;
    imgs[i].style.top = disp_y + px;
   };
  };
 };
}