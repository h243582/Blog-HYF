
insert into config(`key`,value,application,comment)SELECT 'comment.notify.channel', 'mail', 'application', '博主接收评论提醒方式: Telegram=tg 邮箱=mail (访客评论提醒固定为邮箱方式)'
where not exists(select 1 from config where `key`='comment.notify.channel');

insert into config(`key`,value,application,comment)SELECT 'comment.default-open', 'true', 'application', '新评论是否默认公开'
where not exists(select 1 from config where `key`='comment.default-open');


insert into config(`key`,value,application,comment)SELECT 'spring.mail.host', 'smtp.mxhichina.com', 'application', ''
where not exists(select 1 from config where `key`='spring.mail.host');

insert into config(`key`,value,application,comment)SELECT 'spring.mail.port', '25', 'application', ''
where not exists(select 1 from config where `key`='spring.mail.port');

insert into config(`key`,value,application,comment)SELECT 'spring.mail.username', '邮箱账号', 'application', ''
where not exists(select 1 from config where `key`='spring.mail.username');

insert into config(`key`,value,application,comment)SELECT 'spring.mail.password', '邮箱密码', 'application', ''
where not exists(select 1 from config where `key`='spring.mail.password');

insert into config(`key`,value,application,comment)SELECT 'tg.bot.api', 'https://api.telegram.org/bot', 'application', '如果选择邮箱提醒方式，以下可以无需修改'
where not exists(select 1 from config where `key`='tg.bot.api');

insert into config(`key`,value,application,comment)SELECT 'tg.bot.token', '1234567890:qwertyuiopasdfghjklzxcvbnm', 'application', 'bot的token，可以从 @BotFather 处获取'
where not exists(select 1 from config where `key`='tg.bot.token');

insert into config(`key`,value,application,comment)SELECT 'tg.bot.chat-id', '1234567890', 'application', '自己账号和bot的聊天会话id'
where not exists(select 1 from config where `key`='tg.bot.chat-id');

insert into config(`key`,value,application,comment)SELECT 'tg.bot.use-proxy', 'false', 'application', '是否使用代理'
where not exists(select 1 from config where `key`='tg.bot.use-proxy');

insert into config(`key`,value,application,comment)SELECT 'tg.bot.use-reverse-proxy', 'true', 'application', '是否使用反向代理'
where not exists(select 1 from config where `key`='tg.bot.use-reverse-proxy');

insert into config(`key`,value,application,comment)SELECT 'tg.bot.reverse-proxy-url', 'https://tg-api-open.naccl.workers.dev', 'application', '反向代理URL，请自行搭建，示例API随时可能关闭'
where not exists(select 1 from config where `key`='tg.bot.reverse-proxy-url');

insert into config(`key`,value,application,comment)SELECT 'http.proxy.server.host', '127.0.0.1', 'application', '代理配置，如不使用无需修改 (目前用于发送Telegram请求)'
where not exists(select 1 from config where `key`='http.proxy.server.host');

insert into config(`key`,value,application,comment)SELECT 'http.proxy.server.port', '7890', 'application', '代理配置，如不使用无需修改 (目前用于发送Telegram请求)'
where not exists(select 1 from config where `key`='http.proxy.server.port');

insert into config(`key`,value,application,comment)SELECT 'http.proxy.server.timeout', '10000', 'application', '代理配置，如不使用无需修改 (目前用于发送Telegram请求)'
where not exists(select 1 from config where `key`='http.proxy.server.timeout');

insert into config(`key`,value,application,comment)SELECT '评论中QQ头像存储方式: 本地:local GitHub:github 又拍云:upyun', '值', 'application', ''
where not exists(select 1 from config where `key`='评论中QQ头像存储方式: 本地:local GitHub:github 又拍云:upyun');

insert into config(`key`,value,application,comment)SELECT 'upload.channel', 'local', 'application', '评论中QQ头像存储方式: 本地:local GitHub:github 又拍云:upyun'
where not exists(select 1 from config where `key`='upload.channel');

insert into config(`key`,value,application,comment)SELECT 'upload.file.path', '/Users/naccl/Desktop/upload/', 'application', '静态文件上传访问路径 Windows环境例如: C:/Users/nblog/Desktop/upload/ Linux环境例如：/home/nblog/upload/'
where not exists(select 1 from config where `key`='upload.file.path');

insert into config(`key`,value,application,comment)SELECT 'upload.file.access-path', '/image/**', 'application', '静态文件上传访问路径 Windows环境例如: C:/Users/nblog/Desktop/upload/ Linux环境例如：/home/nblog/upload/'
where not exists(select 1 from config where `key`='upload.file.access-path');

insert into config(`key`,value,application,comment)SELECT 'upload.file.resources-locations', 'file:${upload.file.path}', 'application', '静态文件上传访问路径 Windows环境例如: C:/Users/nblog/Desktop/upload/ Linux环境例如：/home/nblog/upload/'
where not exists(select 1 from config where `key`='upload.file.resources-locations');


insert into config(`key`,value,application,comment)SELECT 'upload.github.token', 'ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'application', '如果选择其它上传方式，以下可以无需修改'
where not exists(select 1 from config where `key`='upload.github.token');

insert into config(`key`,value,application,comment)SELECT 'upload.github.username', 'Naccl', 'application', '如果选择其它上传方式，以下可以无需修改'
where not exists(select 1 from config where `key`='upload.github.username');

insert into config(`key`,value,application,comment)SELECT 'upload.github.repos', 'test', 'application', '如果选择其它上传方式，以下可以无需修改。需要用作图床的GitHub仓库名'
where not exists(select 1 from config where `key`='upload.github.repos');

insert into config(`key`,value,application,comment)SELECT 'upload.github.repos-path', '/comment/avatar', 'application', '如果选择其它上传方式，以下可以无需修改。需要上传至仓库的路径 开头需要"/" 结尾不要"/"'
where not exists(select 1 from config where `key`='upload.github.repos-path');

insert into config(`key`,value,application,comment)SELECT '键', '值', 'application', '如果选择其它上传方式，以下可以无需修改'
where not exists(select 1 from config where `key`='键');


insert into config(`key`,value,application,comment)SELECT 'upload.upyun.bucket-name', 'nblog', 'application', '又拍云：又拍云存储空间名称，帮助文档见 https://help.upyun.com/knowledge-base/quick_start/'
where not exists(select 1 from config where `key`='upload.upyun.bucket-name');

insert into config(`key`,value,application,comment)SELECT 'upload.upyun.username', 'naccl', 'application', '又拍云：操作员名称'
where not exists(select 1 from config where `key`='upload.upyun.username');

insert into config(`key`,value,application,comment)SELECT 'upload.upyun.password', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'application', '又拍云：操作员密码'
where not exists(select 1 from config where `key`='upload.upyun.password');

insert into config(`key`,value,application,comment)SELECT 'upload.upyun.path', '/comment/avatar', 'application', '又拍云：存储路径'
where not exists(select 1 from config where `key`='upload.upyun.path');

insert into config(`key`,value,application,comment)SELECT 'upload.upyun.domain', 'https://cdn.example.com', 'application', '又拍云：CDN访问域名'
where not exists(select 1 from config where `key`='upload.upyun.domain');

