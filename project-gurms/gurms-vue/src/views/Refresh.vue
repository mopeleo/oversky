<script>
export default {
    beforeRouteEnter(to, from, next) {
        next(vm => {
            vm.$store.commit('pub/CHANGENETWORK', true);
            vm.$router.replace(from.path);
        })
    }
}
</script>
