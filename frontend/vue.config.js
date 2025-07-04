const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave:false,
  publicPath: './',

  devServer: {

    host: "0.0.0.0",

    port: "9092", // ´úÀí¶Ë¿Ú

  },  
})