const form = document.getElementById("login-form");

form.addEventListener("submit", function (event) {
    event.preventDefault();

    const login = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    };

    fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(login)
    })
        .then(res => {
            if (!res.ok) throw new Error("Invalid user or password");

            const token = res.headers.get("Authorization");
            if (!token) throw new Error("Token not received");

            localStorage.setItem("token", token);

            window.location.href = "index.html";
        })
        .catch(err => {
            alert(err.message);
        });
})