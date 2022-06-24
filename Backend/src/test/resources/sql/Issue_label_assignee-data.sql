INSERT INTO `issue_group` (`id`, `name`, `created_at`, `last_modified_at`) VALUES (1, 'default', '2022-06-23 11:16:38.000000', '2022-06-23 11:16:38.000000');

INSERT INTO `member` (`id`, `deleted`, `github_id`, `name`, `profile_image_url`) VALUES (1, 0, 'jinan159', '김진완', 'https://avatars.githubusercontent.com/u/45728407?v=4');
INSERT INTO `member` (`id`, `deleted`, `github_id`, `name`, `profile_image_url`) VALUES (2, 0, 'devjun10', '정준우', 'https://avatars.githubusercontent.com/u/92818747?v=4');

INSERT INTO `issue_group_member` (`id`, `issue_group_id`, `member_id`) VALUES (1, 1, 1);
INSERT INTO `issue_group_member` (`id`, `issue_group_id`, `member_id`) VALUES (2, 1, 2);

INSERT INTO `issue` (`id`, `created_at`, `last_modified_at`, `deleted`, `issue_status`, `title`, `author_id`, `issue_group_id`, `milestone_id`, `content`) VALUES (1, '2022-06-23 11:26:06', '2022-06-23 11:26:06', 0, 'OPEN', '안녕하세요', 1, 1, null, '안녕하세요 저는 jay 입니다.');
INSERT INTO `issue` (`id`, `created_at`, `last_modified_at`, `deleted`, `issue_status`, `title`, `author_id`, `issue_group_id`, `milestone_id`, `content`) VALUES (2, '2022-06-23 11:27:06', '2022-06-23 11:27:06', 0, 'OPEN', '반갑습니다', 2, 1, null, '반갑습니다 저는 jun 입니다.');

INSERT INTO `label` (`id`, `color`, `description`, `name`) VALUES (1, 'eb4034', 'For emergency issue.', 'emergency');
INSERT INTO `label` (`id`, `color`, `description`, `name`) VALUES (2, '417bd1', 'For enhancement', 'enhancement');

INSERT INTO `issue_label` (`id`, `issue_id`, `label_id`) VALUES (1, 1, 1);
INSERT INTO `issue_label` (`id`, `issue_id`, `label_id`) VALUES (2, 1, 2);
INSERT INTO `issue_label` (`id`, `issue_id`, `label_id`) VALUES (3, 2, 2);

INSERT INTO `assignee` (`id`, `issue_id`, `member_id`) VALUES (1, 1, 1);
INSERT INTO `assignee` (`id`, `issue_id`, `member_id`) VALUES (2, 1, 2);
INSERT INTO `assignee` (`id`, `issue_id`, `member_id`) VALUES (3, 2, 2);
