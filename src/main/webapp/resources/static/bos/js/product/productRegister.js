

// window.onload = function() {
//
//
//
//     console.log('sdfsdf');
//     let middleNo=1;
//     const options = document.querySelectorAll('#cate_small option[data-small-key="1"]');
//     options.forEach(function(option) {
//         console.log(option.dataset.smallKey);
//     });
// };

$(document).ready(function(){
    $('#summernote').summernote({
        placeholder: 'Hello stand alone ui',
        tabsize: 2,
        height: 300,
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture', 'video']],
            ['view', ['fullscreen', 'codeview', 'help']]
        ]
    });

    const small = $('#cate_small').children();
    $(small).hide();
    $('#cate_middle').change(function() {
        const middle = $(this).val(); // 선택된 option 값 가져오기

        for(let i=0;i<small.length;i++){
            if(small[i].dataset.smallKey == middle){
                $(small[i]).show();
            }else{
                $(small[i]).hide();
            }
        }
    });



    // for(let i=0;i<small.length;i++){
    //     if(small[i].text ==='2'){
    //         $(small[i]).show();
    //
    //     }else {
    //         $(small[i]).hide();
    //     }
    // }


    // $('#cate_middle').change(function() { // 중간 카테고리를 변경할 때
    //     var selectedValue = $(this).val(); // 선택된 값
    //     $('#cate_small option').each(function() { // 각 소형 카테고리에 대해
    //         var smallKey = $(this).data('small-key'); // data-small-key값 추출
    //         if(smallKey === selectedValue) { // 선택된 중간 카테고리 값과 일치하면
    //             $(this).show(); // 해당 소형 카테고리 보여주기
    //         } else {
    //             $(this).hide(); // 그렇지 않으면 숨기기
    //         }
    //     });
    // });
});




