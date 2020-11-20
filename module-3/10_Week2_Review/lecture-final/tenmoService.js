const BASE_URL = 'http://localhost:8080';
let token = '';

function login(username, password) {
  // path:  /login
  // method: POST
  // data: { username, password }

  const data = {
    username: username,
    password: password
  };

  const options = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  };

  return fetch(`${BASE_URL}/login`, options)
    .then((res) => res.json())
    .then((data) => token = data.token);
}

function getAccountBalance() {
  // path: /account/balance
  // method: GET
  // headers: auth token

  const options = {
    method: 'GET',
    headers: {
      'Authorization': 'Bearer ' + token
    }
  };

  return fetch(`${BASE_URL}/account/balance`, options)
    .then(res => res.json())
    .then(data => data);
}

export default {
  login,
  getAccountBalance
};