import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    reviews: [
      {
        id: 1,
        reviewer: "Malcolm Gladwell",
        title: "What a book!",
        review: "It is certainly a book.",
        stars: 3,
        favorited: true,
      },
      {
        id: 2,
        reviewer: "Walt Impellicceiri",
        title: "Best book ever!",
        review: "Literally the best book ever guys!",
        stars: 5,
        favorited: false,
      },
    ],

    numberOfStarsFilter: 5,
  },
  mutations: {
    UPDATE_FILTER(state, newFilter) {
      state.numberOfStarsFilter = newFilter;
    },
    ADD_REVIEW(state, newReview) {
      state.reviews.push(newReview);
    },
    FLIP_FAVORITED(state, reviewToFlip) {
      reviewToFlip.favorited = !reviewToFlip.favorited;
    }
  },
  actions: {
  },
  modules: {
  }
})
