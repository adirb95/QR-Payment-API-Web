# QR Payment API + Web

Our very first API and web application!

This repository contains the web application and the API for the QR Payment project.

The web app serves a merchant to generate a unique QR code with transaction information. The app is developed with JavaScript, HTML and CSS.

At the sign-in page you need to use your business / store e-mail address and password.

![alt text](https://github.com/SharonMauda/Git-Pictures/blob/main/web%20homepage.png?raw=true)

Once you're logged-in, you're directed to the main page. Here you can enter a desired transaction price or watch your transactions history.

![alt text](https://github.com/SharonMauda/Git-Pictures/blob/main/web%20logged%20in.png?raw=true)

When you enter a price and click the Generate QR button, a QR code will appear aside. The QR code contains all your personal information as it's stored at the database and will include the price you just entered. The code is now ready to be decoded by a customer!

![alt text](https://github.com/SharonMauda/Git-Pictures/blob/main/web%20QR.png?raw=true)

The history page will show you all the transactions you initiated and have been approved by customers. You can see whether the transaction has been approved or not.

![alt text](https://github.com/SharonMauda/Git-Pictures/blob/main/web%20history.png?raw=true)

**The API is used by both the web application and the android application. It allows both to connect to the database and get the information they need. The API is developed with Java using Spring Framework.**
