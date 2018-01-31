$(function() {
    // get token
    $.ajax({
        url:  $('script[src*=app]').attr('data-backend') +"/login",
        type: "POST",
        success: function (response) {
            localStorage.setItem('token', response.token);
        },
        error: function (response) {
            alert('error during login, please try again');
        },
    });

    $("#btnFindMovie").on("click", function() {
        $.ajax({
            url: $('script[src*=app]').attr('data-backend') +"/recommendation",
            type: "POST",
            data: {
                genreId: $('#genreId').val(),
                token: localStorage.getItem('token')
            },
            success: function (response) {
                $("#recMovie").text(response.movieName);
                $("#recDesc").text(response.description);
                $("#header").css("background-image", "url(" + response.imageUrl + ")");

                //reload history
                $.ajax({
                    url: $('script[src*=app]').attr('data-backend') +"/history",
                    type: "GET",
                    data: {
                        token: localStorage.getItem('token')
                    },
                    success: function (response) {

                      for (var i = 0; i < response.items.length; i++) {
                        var movie = response.items[i].result;
                        $("#history").append('<article class="6u 12u$(xsmall) work-item">' +
                                '<a href="images/fulls/01.jpg" class="image fit thumb"><img src="' + movie.imageUrl + '" title="' + movie.movieName + '" /></a>' +
                                '<h3>' + movie.movieName + '</h3>' +
                                '<p>' + movie.description + '</p>' +
                            '</article>');
                      }
                    },
                    error: function (response) {
                        alert('error loading history');
                    },
                });
            },
            error: function (response) {
                alert('could not get your recommendation, sorry!');
            },
        });
    });
})
