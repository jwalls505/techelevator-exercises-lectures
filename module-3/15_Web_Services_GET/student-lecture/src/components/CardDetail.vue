<template>
  <div>
    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <div v-else>
      <h1>{{ card.title }}</h1>
      <p>{{ card.description }}</p>
      <comments-list v-bind:comments="card.comments" />
      <div class="board-actions">
        <router-link
          v-bind:to="{ name: 'Board', params: { id: $route.params.boardID } }"
        >
          Back to Boards
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import CommentsList from "../components/CommentsList.vue";
import boardService from "../services/BoardService.js";
export default {
  name: "card-detail",
  components: {
    CommentsList,
  },
  data() {
    return {
      card: {
        title: "",
        description: "",
        status: "",
        comments: [],
      },
      isLoading: true,
    };
  },
  created() {
    this.boardService
      .getCard(this.$route.params.boardID, this.$route.params.cardID)
      .then((card) => {
        this.card = card;
        this.isLoading = false;
      });
  },
};
</script>
