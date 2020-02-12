FROM mariadb:10.3

RUN { \
    echo '[client]'; \
    echo 'default-character-set=utf8'; \
    echo '[mysqld]'; \
    echo 'character-set-server=utf8'; \
    echo 'collation-server=utf8_unicode_ci'; \
} > /etc/mysql/conf.d/my.cnf

COPY db/init.sql ./docker-entrypoint-initdb.d/prepare.sql
