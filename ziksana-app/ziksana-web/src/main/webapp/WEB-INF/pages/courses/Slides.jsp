<!doctype html>
    <head>
        <title>Title</title>
    
        <style type="text/css" media="screen">
            .slides_container {
                width:570px;
                height:270px;
            }
            .slides_container div {
                width:570px;
                height:270px;
                display:block;
            }
        </style>
    
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script src="slides.jquery.js"></script>
    
        <script>
            $(function(){
                $("#slides").slides();
            });
        </script>
    </head>
    <body>
        <div id="slides">
            <div class="slides_container">
                <div>
                    <img src="http://placehold.it/570x270">
                </div>
                <div>
                    <img src="http://placehold.it/570x270">
                </div>
                <div>
                    <img src="http://placehold.it/570x270">
                </div>
                <div>
                    <img src="http://placehold.it/570x270">
                </div>
            </div>
        </div>
    </body>