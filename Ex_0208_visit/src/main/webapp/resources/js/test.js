$(function(){
    var plugins = [
        "advlist", "autolink", "lists","charmap", "print", "preview", "anchor",
        "searchreplace", "visualblocks", "code", "fullscreen", "insertdatetime", "media", "table",
        "paste", "code", "help", "wordcount", "save"
    ];
    var edit_toolbar = 'formatselect fontselect fontsizeselect |'
               + ' forecolor backcolor |'
               + ' bold italic underline strikethrough |'
               + ' alignjustify alignleft aligncenter alignright |'
               + ' bullist numlist |'
               + ' table tabledelete |'

    tinymce.init({
    	language: "ko_KR", //한글판으로 변경
        selector: '#editor',
        height: 500,
        menubar: false,
        plugins: plugins,
        toolbar: edit_toolbar,
        
        image_title: true,
        automatic_uploads: true,
     
        file_picker_types: 'image',
        file_picker_callback: function (cb, value, meta) {
            var input = document.createElement('input');
            input.setAttribute('type', 'file');
            input.setAttribute('accept', 'image/*');

       
            input.onchange = function () {
                var file = this.files[0];

                var reader = new FileReader();
                reader.onload = function () {
                  
                    cb(blobInfo.blobUri(), { title: file.name });
                };
                reader.readAsDataURL(file);
            };
            input.click();
        },
        /*** image upload ***/
        
        content_style: 'body { font-family:Helvetica,Arial,sans-serif; font-size:14px }'
    });


    $("#save").on("click", function(){
        var content = tinymce.activeEditor.getContent();
        console.log(content);
    });
 });