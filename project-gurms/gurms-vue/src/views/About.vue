<template>
    <div class="about">
        <h1>
        welcome: {{$store.getters['pub/userinfo'].username}}, 公司123名称： {{$store.state.pub.user.orgid}}
        This is an about page
        </h1>
    </div>
</template>
