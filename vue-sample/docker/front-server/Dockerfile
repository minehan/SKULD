FROM node:10.15-alpine
WORKDIR /app
COPY front/package.json ./package.json
COPY front/public ./public
COPY front/src ./src
COPY front/babel.config.js ./babel.config.js
COPY front/vue.config.js ./vue.config.js
COPY front/.eslintrc.js ./.eslintrc.js
RUN apk update && \
    npm cache clean --force && \
    npm install -g npm && \
    npm install -g yarn && \
    yarn install
CMD ["/bin/sh"]
