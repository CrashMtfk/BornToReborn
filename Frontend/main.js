function handleSubmit(event) {
    event.preventDefault();
    const inputs = document.querySelectorAll('input');
    console.log(inputs);
    const user = {};
    for(i in inputs){
        user[inputs[i].name] = inputs[i].value;
        console.log(inputs[i].name + " " + inputs[i].value + " " + user);
    }
    console.log(user);

    let xhr = new XMLHttpRequest();
    let url = "localhost:8080/Person.java";

    // open a connection
    xhr.open("POST", url, true);

    // Set the request header i.e. which type of content you are sending
    xhr.setRequestHeader("Content-Type", "application/json");

    // Create a state change callback
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {

            // Print received data from server
            result.innerHTML = this.responseText;

        }
    };

    // Converting JSON data to string
    
    // Sending data with the request
    xhr.send(user);
  }
  

  