<template>
  <div>
    <form class="new-book-form" v-on:submit.prevent="addNewBook">
      <label for="title-input">Title:</label>
      <input class="title-input" v-model="newBook.title" />
      <label for="author-input">Author:</label>
      <input class="author-input" v-model="newBook.author" />
      <label for="isbn-input">ISBN:</label>
      <input class="isbn-input" v-model="newBook.isbn" />
      <input type="submit" value="Add Book" />
      <input type="button" value="Reset" v-on:click.prevent="resetForm" />
    </form>
  </div>
</template>
<script>
export default {
  name: "new-book-form",
  data() {
    return {
      newBook: {
        title: "",
        author: "",
        isbn: "",
        read: false,
      },
    };
  },
  methods: {
    addNewBook() {
      this.$store.commit("ADD_BOOK", this.newBook);
    },
    resetForm() {
      this.newBook = {};
    },
  },
};
</script>

<style scoped>
</style>