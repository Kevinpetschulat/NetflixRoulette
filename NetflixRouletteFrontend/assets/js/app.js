$(function() {

    // get token
    $.ajax({
        url:  $('script[src*=app]').attr('data-backend') +"/login",
        type: "POST",
        beforeSend: function() {
          $("#btnFindMovie").addClass( "disabled" );
          $("#message").text("Please wait a moment...");
        },
        success: function (response) {
            localStorage.setItem('token', response.token);
            $( "#btnFindMovie" ).removeClass( "disabled" );
            $("#message").text("");
        },
        error: function (response) {
            alert('error during login, please try again');
        },
    });

    $("#btnFindMovie").on("click", function() {
        if (!$( "#btnFindMovie" ).hasClass( "disabled" ))
        {
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
        }
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
        	},
        	error: function (response) {
            	alert('could not clear your history, sorry!');
        	},
      	});
  });

})
