$(document).ready(function () {
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
    $('#cate_middle').change(function () {
        const middle = $(this).val(); // 선택된 option 값 가져오기

        for (let i = 0; i < small.length; i++) {
            if (small[i].dataset.smallKey == middle) {
                $(small[i]).show();
            } else {
                $(small[i]).hide();
            }
        }
    });


    const dcContent = $('.dc_content').hide();
    $('#dc_btnradio').click(function () {
        dcContent.show(); // "설정함" 클릭시 행을 보여줍니다.
    });

    $('#dc_btnradio_no').click(function () {
        dcContent.hide(); // "설정안함" 클릭시 행을 숨깁니다.
    });

    // $('#dc_date').change(function() {
    //     if ($(this).is(':checked')) {
    //         $('.dc_content_date').css('display', 'table-row');
    //     } else {
    //         $('.dc_content_date').css('display', 'none');
    //     }
    // });

    const saleDate = $('.sale_date').hide();
    $('#sale_date').click(function () {
        saleDate.show();
    });
    $('#no_sale_date').click(function () {
        saleDate.hide();
    });

    //cateId 찾기
    const cateList = JSON.parse(document.getElementById('jsonCateList').value);
    const selectLarge = document.getElementById("cate_large");
    const selectMiddle = document.getElementById("cate_middle");
    const selectSmall = document.getElementById("cate_small");


    cateList.forEach((cate)=>{
        if(parseInt(selectSmall.value)===cate.smallNo && parseInt(selectMiddle.value)===cate.middleNo && parseInt(selectLarge.value)===cate.largeNo){
            console.log(cate.cateId);
            cateIdInput.value = cate.cateId;
        }
    });





});



