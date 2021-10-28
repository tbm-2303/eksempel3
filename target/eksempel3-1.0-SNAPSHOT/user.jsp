<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <title>UserPage</title>
</head>


<body>
<div class="p-5 mb-4 bg-light rounded-3">
    <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">Pokemon Selector</h1>
        <p class="col-md-8 fs-4">Using a series of utilities, you can create this jumbotron, just like the one in
            previous versions of Bootstrap. Check out the examples below for how you can remix and restyle it to your
            liking.</p>

        <form action="ServletPokemon" method="get">

            <div class="mb-3">
                <label for="pokemon" class="form-label">Type a Pokemon</label>
                <input class="form-control" type="text" name="pokemon" id="pokemon" placeholder="Type a pokemon:"><br>
            </div>
            <div class="mb-3">
                <label for="formFile" class="form-label">Select pokemon img</label>
                <input class="form-control" type="file" id="formFile">
            </div>

            <br>

            <select class="form-select" aria-label="Default select example">
                <option selected>Select the set number</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
                <option value="4">Three</option>
                <option value="5">Three</option>
                <option value="6">Three</option>
                <option value="7">Three</option>
            </select>
            <br>

            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                <label class="form-check-label" for="flexCheckDefault">
                    Over 5
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                <label class="form-check-label" for="flexCheckChecked">
                    Under 5
                </label>
            </div>

            <br>

            <label for="customRange1" class="form-label ">Quantity:</label>
            <input type="range" class="slider" id="customRange1" min="1" max="10"><br>

            <input class="btn btn-primary " type="submit" value="Submit pokemon">
        </form>

        <br>

        <form action="ServletAllPokemon" method="get">
            <input class="btn btn-primary " type="submit" value="Go to list of all pokemon">
        </form>

        <br>

        <p>You submitted a Pokemon by the name:</p>
        ${requestScope.PokemonSubmission}<br>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>


</html>