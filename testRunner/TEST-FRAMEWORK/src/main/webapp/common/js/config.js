CKEDITOR.editorConfig = function(config) {
    config.resize_enabled = false;
    config.toolbar = 'Simple';
    config.toolbar_Simple = [ [ 'Bold', 'Italic','Underline', 'Strike', '-', 'NumberedList', 'BulletedList', '-', 'Link', 'Unlink',   ] ,
                              [ 'Undo', 'Redo', '-', 'JustifyLeft', 'JustifyCenter',
                                'JustifyRight', 'JustifyBlock' ],];
    config.toolbar_Complex = [
            [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript',
                    'Superscript', 'TextColor', 'BGColor', '-', 'Cut', 'Copy',
                    'Paste', 'Link', 'Unlink', 'Image'],
            [ 'Undo', 'Redo', '-', 'JustifyLeft', 'JustifyCenter',
                    'JustifyRight', 'JustifyBlock' ],
            [ 'Table', 'Smiley', 'SpecialChar', 'PageBreak',
                    'Styles', 'Format', 'Font', 'FontSize', 'Maximize'] ];
};

/**
 * 
 */