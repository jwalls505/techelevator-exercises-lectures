<template>
  <div class="main">
    <h1>{{ product.name }}</h1>
    <p class="description">{{ product.description }}</p>
    <nav class="actions">
      <router-link :to="{ name: 'products' }"> Back to Products </router-link>
      |
      <router-link :to="{ name: 'add-review', params: { id: product.id } }"
        >Add Review</router-link
      >
    </nav>
    <div class="well-display">
      <average-summary />
      <star-summary :rating="1" />
      <star-summary :rating="2" />
      <star-summary :rating="3" />
      <star-summary :rating="4" />
      <star-summary :rating="5" />
    </div>
    <review-list />
  </div>
</template>

<script>
import AverageSummary from "../components/AverageSummary.vue";
import ReviewList from "../components/ReviewList.vue";
import StarSummary from "../components/StarSummary.vue";

export default {
  name: "product-detail",

  components: {
    AverageSummary,
    ReviewList,
    StarSummary,
  },

  created() {
    this.$store.commit("SET_ACTIVE_PRODUCT", this.$route.params.id);
  },

  computed: {
    product() {
      return this.$store.state.products.find((p) => {
        return p.id == this.$store.state.activeProduct;
      });
    },
  },
};
</script>