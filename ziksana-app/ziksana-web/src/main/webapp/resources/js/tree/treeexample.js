
        $(document).ready(function () {
            // Create jqxTree 
            var theme = getTheme();
            // create jqxTree
            $('#jqxTree').jqxTree({ height: '400px', hasThreeStates: true, checkboxes: true, width: '330px', theme: theme });
            $('#jqxCheckBox').jqxCheckBox({ width: '200px', height: '25px', checked: true, theme: theme });
            $('#jqxCheckBox').bind('change', function (event) {
                var checked = event.args.checked;
                $('#jqxTree').jqxTree({ hasThreeStates: checked });
            });
            $("#jqxTree").jqxTree('selectItem', $("#home")[0]);
        });