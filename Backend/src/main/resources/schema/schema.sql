create table assignee
(
    id        bigint not null auto_increment,
    issue_id  bigint,
    member_id bigint,
    primary key (id)
) engine = InnoDB;

create table comment
(
    id               bigint not null auto_increment,
    created_at       datetime(6),
    last_modified_at datetime(6),
    content          longtext,
    issue_id         bigint,
    member_id        bigint,
    primary key (id)
) engine = InnoDB;

create table emoji
(
    id         bigint not null auto_increment,
    emotion    varchar(4),
    comment_id bigint,
    primary key (id)
) engine = InnoDB;

create table group_member
(
    id        bigint not null auto_increment,
    member_id bigint,
    group_id  bigint,
    primary key (id)
) engine = InnoDB;

create table image
(
    id         bigint not null auto_increment,
    file_name  varchar(4096),
    url        varchar(2048),
    comment_id bigint,
    primary key (id)
) engine = InnoDB;

create table issue
(
    id               bigint not null auto_increment,
    created_at       datetime(6),
    last_modified_at datetime(6),
    issue_status     varchar(255),
    title            varchar(60),
    milestone_id     bigint,
    primary key (id)
) engine = InnoDB;

create table label
(
    id          bigint not null auto_increment,
    color       varchar(6),
    description varchar(100),
    name        varchar(50),
    issue_id    bigint,
    primary key (id)
) engine = InnoDB;

create table member
(
    id                bigint not null auto_increment,
    name              varchar(39),
    profile_image_url varchar(2048),
    primary key (id)
) engine = InnoDB;

create table member_group
(
    member_group_id  bigint not null auto_increment,
    created_at       datetime(6),
    last_modified_at datetime(6),
    name             varchar(100),
    primary key (member_group_id)
) engine = InnoDB;

create table milestone
(
    id               bigint not null auto_increment,
    created_at       datetime(6),
    last_modified_at datetime(6),
    description      varchar(8192),
    due_date         date,
    title            varchar(255),
    primary key (id)
) engine = InnoDB;

alter table assignee
    add constraint FKi0gh3rd0yehds324xt45vna73
        foreign key (issue_id)
            references issue (id);

alter table assignee
    add constraint FKhfo61ma0iv0q4dyayehcl0s6p
        foreign key (member_id)
            references member (id);

alter table comment
    add constraint FKomjg70m9sundkar1el2rtonrn
        foreign key (issue_id)
            references issue (id);

alter table comment
    add constraint FKmrrrpi513ssu63i2783jyiv9m
        foreign key (member_id)
            references member (id);

alter table emoji
    add constraint FKrkl6s3i656cyjshf60sfms1tg
        foreign key (comment_id)
            references comment (id);

alter table group_member
    add constraint FKeamf7nngsg582uxwqgde8o28x
        foreign key (member_id)
            references member (id);

alter table group_member
    add constraint FK4if69kgijmtu6wa8jh8a19mwf
        foreign key (group_id)
            references member_group (member_group_id);

alter table image
    add constraint FK973ib8k6ri8g8nlfi6i52mpo6
        foreign key (comment_id)
            references comment (id);

alter table issue
    add constraint FK7t1o4tuel06m9bn4dppqmiod6
        foreign key (milestone_id)
            references milestone (id);

alter table label
    add constraint FKskssx8qtjj0fkn678hop4flwx
        foreign key (issue_id)
            references issue (id)
