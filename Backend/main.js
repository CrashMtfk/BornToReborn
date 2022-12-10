const form = document.querySelector('form');
var Data = new Array();
var i = 0;

form.addEventListener('submit', (e) => {
    e.preventDefault();
    const formData = new FormData(form);
    const obj = Object.fromEntries(formData);  
    //console.log(obj);
    const json = JSON.stringify(obj);
    localStorage.setItem('form', json);
    window.location.href = "BornToReborn/Frontend/profile_page/profile.html";
    //console.log(localStorage);
    let user = {
        "nume" : document.getElementById("user").value,
        "email" : document.getElementById("email").value
    }
    Data.push(user);
    console.log(Data);
})

