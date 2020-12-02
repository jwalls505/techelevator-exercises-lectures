import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {
  getAnError() {
    return http.get('/someRouteThatDoesNotExist');
  },

  getBoards() {
    return http.get('/boards');
  },

  getCards(boardID) {
    return http.get(`/boards/${boardID}`)
  },

  getCard(boardID, cardID) {
    return http.get(`/boards/${boardID}`).then((response) => {
      const cards = response.data.cards;
      return cards.find(card => card.id == cardID);
    })
  }

}
