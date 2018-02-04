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
					  $("#history").html('');

                      for (var i = 0; i < response.items.length; i++) {
                        var movie = response.items[i].result;
                        $("#history").append('<article class="6u 12u$(xsmall) work-item">' +
                                '<img src="' + movie.imageUrl + '" title="' + movie.movieName + '"  class="image fit thumb" />' +
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

    $("#btnClearHistory").on("click", function() {
        	$.ajax({
            	url: $('script[src*=app]').attr('data-backend') +"/clearHistory",
            	type: "GET",
            	data: {
                	token: localStorage.getItem('token')
            	},
            	success: function (response) {
       			 $("#history").html('');

                	alert('History is now cleared');
            	},
            	error: function (response) {
                	alert('could not clear your history, sorry!');
            	},
        	});
    });
})
