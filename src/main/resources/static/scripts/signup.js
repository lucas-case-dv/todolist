const form = document.getElementById("signup-form");

form.addEventListener("submit", function (event) {
    event.preventDefault();

    const user = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    };

    fetch("/user", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    })
        .then(res => {
            if (!res.ok) throw new Error("Registration error");
        })
        .then(() => {
            alert("User created!");
        })
        .catch(err => {
            alert(err.message);
        });
});