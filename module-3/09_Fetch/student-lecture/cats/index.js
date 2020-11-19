const catContainer = document.getElementById('catContainer');
const requestOrder = document.getElementById('requestOrder');
const responseOrder = document.getElementById('responseOrder');
for (let i = 0; i < 5; i++) {
    const requestElement = document.createElement('li');
    requestElement.innerText = 'Request: ' + (i + 1);
    requestOrder.appendChild(requestElement);
    fetch('https://api.thecatapi.com/v1/images/search?size=full')
        .then((response) => {
            return response.json(); //parses response as json
        })
        .then((jsonData) => {
            const body = document.querySelector('body');
            body.innerHTML = jsonData[0].url;

            const catImage = document.createElement('img');
            catImage.setAttribute('src', jsonData[0].url);
            catContainer.appendChild(catImage);

            const responseElement = document.createElement('li');
            responseElement.innerText = 'Response: ' + (i + 1);
            responseOrder.appendChild(responseElement);


        });
    console.log('After Fetch');

}




