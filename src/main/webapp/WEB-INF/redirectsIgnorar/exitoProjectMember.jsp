<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Exito!</title>
<<<<<<< HEAD
        <meta http-equiv="refresh" content="4;url=http://localhost:8080/demo/ProyectoController?accion=RedirectAgregarProjectMembers">
=======
        <meta http-equiv="refresh" content="4;url=http://localhost:8081/SistemaAgil_IS2_war/ProyectoController?accion=RedirectAgregarProjectMembers">
>>>>>>> af6bf83b5dfb331cfe706c16ab1584f001096163
        <script>
			var count = 3; // Number of remaining seconds.
			var counter; // Handle for the countdown event.
			
			function start() {
				counter = setInterval(timer, 1000);
			}

			function timer() {
				// Show the number of remaining seconds on the web page.
				var output = document.getElementById("displaySeconds");
				output.innerHTML = count;
				
				// Decrease the remaining number of seconds by one.
				count--;
				
				// Check if the counter has reached zero.
				if (count < 0) { // If the counter has reached zero...
					// Stop the counter.
					clearInterval(counter);
				}
			}		
			// Start the countdown timer when the page loads. 
			window.addEventListener("load", start, false);
		</script>
    </head>
    <body>
        <h1>Usuario agregado a Proyecto Exitosamente!</h1>
         <div>Redireccionando en <span id="displaySeconds">3</span> segundos! o presiona el boton</div>
         <br>
         <form action="ProyectoController" method="GET">
            <input type="submit" name="accion" value="RedirectAgregarProjectMembers"><br>
        </form>
    </body>
</html>
