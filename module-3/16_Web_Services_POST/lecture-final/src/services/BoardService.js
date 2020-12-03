import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  deleteBoard(boardID) {
    return http.delete(`/boards/${boardID}`);
  },

  addBoard(board) {
    return http.post('/boards', board);
  },

  getBoards() {
    return http.get('/boards');
  },

  getCards(boardID) {
    return http.get(`/boards/${boardID}`)
  },

  getCard(cardID) {
    return http.get(`/cards/${cardID}`)
  },

  addCard(card) {
    return http.post('/cards', card);
  },

  updateCard(card) {
    return http.put(`/cards/${card.id}`, card);
  },

  deleteCard(cardID) {
    return http.delete(`/cards/${cardID}`);
  }

}