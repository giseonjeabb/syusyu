
// // function submitContents(elClickedObj) {
// //     oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
// //     try {
// //         elClickedObj.form.submit();
// //     } catch(e) {}
// // }
//
//
$(document).ready(function() {
    let oEditors = [];
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: oEditors,
        elPlaceHolder: "smarteditor",
        sSkinURI: "/static/bos/smarteditor/SmartEditor2Skin.html",
        fCreator: "createSEditor2",
        // htParams : {
        //     bUseToolbar: true,
        //     bUseVerticalResizer : true,
        //     bUseModeChanger : true,
        // }
    });
});


