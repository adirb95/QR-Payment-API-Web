
//global variables
var userObj = {};
var currencyEnum = {
    "ILS":"&#8362;",
    "DOLAR":"&#36;",
    "EURO":"&#128;",
}
//global functions
function setUser(user) {
    userObj = user;
}

function setUsername() {
    document.getElementById("username_nav").innerText = userObj.name;
}

function navigate(show, hide) {
    //this function suppose to hide and show pages.
    //the function gets an id of the page to show and the id of the page to hide.
    document.getElementById(show).style = "display:block";
    document.getElementById(hide).style = "display:none";

    if (show === "login_page")
        document.getElementById("main").style = "display:none";
    else {
        setUsername();
        document.getElementById("main").style = "display:block";
    }
}

/*Login Page Functions */
function focusInChangeColor(e) {
    document.getElementById(e.id + "_div").classList.add("after-color")
}

function focusOutChangeColor(e) {
    document.getElementById(e.id + "_div").classList.remove("after-color")
}

function submitLogin() {
    const EMAIL = document.getElementById("email").value;
    const PASSWORD = document.getElementById("password").value;

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({ "email": "ivory@gmail.com", "password": "ivory" });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("https://qr-payment.azurewebsites.net/merchantLogin", requestOptions)
        .then(response => {
            if (response.ok) return response.text();
            else handleError(error);
        })
        .then(result => {
            setUser(JSON.parse(result));
            resetLogin();
            navigate("home_page", "login_page");
        })
        .catch(error => {
            handleError(error)
        });
}

function resetLogin() {
    document.getElementById("email").value = "";
    document.getElementById("password").value = "";
    document.getElementById("error-label-form").classList.remove("has-error");
}

function handleError(error) {
    document.getElementById("error-label-form").classList.add("has-error");
}

function navigateHomePage() {
    document.getElementById("username_nav").value = userObj.name;
}

function setActiveTab(e) {
    let activeElemArr = document.body.getElementsByClassName("active");
    activeElemArr[0].classList.remove('active');
    e.classList.add('active');
}

function generateQR() {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    var raw = JSON.stringify({
        "merchantName": userObj.name,
        "transactionCurrency": userObj.currency,
        "accountNumber": userObj.accountNumber,
        "branchNumber": userObj.branchNumber,
        "bankID": userObj.bankID,
        "price": document.getElementById("price").value
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("https://qr-payment.azurewebsites.net/generateQR", requestOptions)
        .then(response => response.blob())
        .then(blob => {
            var imageUrl = URL.createObjectURL(blob)
            document.getElementById("QR_image").src = imageUrl;
        })
        .catch(error => console.log('error', error));
}

function getHistoryTransactions() {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify(userObj);

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("https://qr-payment.azurewebsites.net/merchantHistory", requestOptions)
        .then(response => response.text())
        .then(result => createHistoryTable(JSON.parse(result)))
        .catch(error => console.log('error', error));
}

function createHistoryTable(transactions) {
    console.log(transactions);
    const tableBody = document.getElementById("history_body_table");
    resetTbody(tableBody);

    transactions.map(transaction => {
        var tr = document.createElement('tr');
        tr.innerHTML = `<tr>
                            <td>${transaction.companyName}</td>
                            <td>${transaction.customer}</td>
                            <td>${transaction.amount} ${currencyEnum[userObj.currency]}</td>
                            <td>${transaction.date}</td>
                            <td>${transaction.status}</td>
                        </tr>`;
        tableBody.appendChild(tr);
    })
}

function resetTbody(tbody){
    for(var i = tbody.rows.length; i>0 ;i--)
        tbody.deleteRow(i-1);
}