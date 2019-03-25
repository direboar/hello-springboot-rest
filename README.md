# 概要
spring webmvc＋spring bootでrestアプリケーションを作成するサンプル。
以下の内容の写経から始まり、その他必要な要素を追加していく予定。

https://spring.io/guides/gs/rest-service/

# ノウハウメモ

## hishidamaさんのサイト
http://www.ne.jp/asahi/hishidama/home/tech/java/spring/boot/index.html

## Developer Tool
- Developer　Toolを設定しないと、SpringBootの自動リスタートが動作しないので、設定が必須。
https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools

- Developer　Toolを設定した場合、eclipse -> 実行 -> Spring Boot Appで動かさないと、自動リスタートが有効にならないので注意

(gradlew bootRunで動かすと、開発モードとして認識されないらしい）
もしくは、Eclipseのビルドパスの設定を、gradleのビルドパスに合わせる。
https://qiita.com/miz21358/items/ae61ebdcbb9d8760e62b
https://www.kaitoy.xyz/2017/01/03/goslings-development-memo1-spring-boot/


