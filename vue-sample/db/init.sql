---- drop ----
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `personal_information`;

---- create ----
CREATE table IF not exists `user` (
  `id` int(11),
  `login_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `salt` char(8) COLLATE utf8mb4_unicode_ci NOT NULL,
  `vaild` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='ユーザーマスター';

CREATE TABLE `personal_information` (
  `id` int(11),
  `user_id` int(11) NOT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_phonetic` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_phonetic` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` enum('男性','女性','中性','') COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int(2) NOT NULL,
  `birthplace` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hire_date` date NOT NULL,
  `rool` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tel` char(13) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='個人情報';

---- insert ----
INSERT INTO `user` (`id`, `login_name`, `password`, `salt`, `vaild`) VALUES
(1, 'nagato', 'password4AACED889A78F502F4231775018135669C004B8102519E72A2F89B23C9B3A58B', 'Duy7abFT', 1),
(2, 'mutu', 'passwordA1BCE7CC4D1CA0D2D6D28F175FF592D61850A42E96DB98C51E7E5D0D1178CAB6', 'LnPiMhLn', 1),
(3, 'ise', 'passwordA0ABC283935F720A5713ADF7D64D53415E44A1FDF113916B8331AACAD184975E', 'LcjtErPk', 1),
(4, 'hyuuga', 'password43D3C09745C8B8478E6E8D54FB41C74358CD22EA004C1D421B3F86A553DC56DC', 'CjVk4rc7', 1),
(5, 'yukikaze', 'password34FCB8F803E7C812374C341A05C23068D20B7C27C88BD76A7A6ECBA9B770B972', 'QJG5xtGY', 1),
(6, 'akagi', 'passwordD530C0FAD62119E76799EE4804C429DAAC9CF64742CC62988B091F357E3D87B9', '2NmicwVU', 1),
(7, 'kaga', 'passwordBAF6D0A26CE5AEC43A487F25C9C5A11D09201B55DDC6106A9F9DACDC090196AD', 'U29z8YDf', 1),
(8, 'souryu', 'passwordCA2EA69EB4CEA33A22E58B9AD2A2CAEDB6296881B5FC5D51C01A7010996BE134', 'kXbLeBR3', 1),
(9, 'hiryuu', 'password0732EB377ED6758B87520840338052DA193C646B41675FFCBEF1EF4A3A4788AE', 'NTMeDYA6', 1),
(10, 'simakaze', 'password3B26EA3B5FFAD7D203F636C5A01D5D479F90B18617D75423FCD6FEA14B1ED197', 'mUzTsB5t', 0),
(11, 'fubuki', 'passwordFC4A9F65C99ECB272CBD25418B254CF7D251677CDCCABB6981D4740BCF2DDE85', 'tCD8sdui', 1),
(12, 'sirayuki', 'password24E54CCE0796CB6E309A79E6EDA04764A9C87AD793AD99BD51A272C1D46B252C', 'KXRFB8s5', 1),
(13, 'hatuyuki', 'password5790DB8417E8808CA4DB16F9F653D329548D08DF6B11952B62C7B78BF865A9C9', 'yr3YdU3G', 1),
(14, 'miyuki', 'passwordA275821BB433D16B6044A8C8B6506538DCFD1BD53C3E1F8A3DF6CB8294A84163', 'mFnyhF8g', 1),
(15, 'murakumo', 'password7412AB8AEEE2FA5EDF8F532AB1066598C5DD292ED1ACF564BBA3CD0C1546CD6C', 'LZsVE8C7', 1),
(16, 'isonami', 'password67F5A494EBF95CC96580AC1B56ABE98549EF027FE4E133534F4E67C9D7267597', 'yeYuQdxp', 1),
(17, 'ayanami', 'password3EC27CE31471681448269CC2B57D7DE11C820B824A220252CE6EA0889203722B', '8x2MSpxb', 1),
(18, 'sikinami', 'password638D6CFE2500BE3E0AF8AAF97939649B68A815EDBFD467103B74B8C8037AA742', 'DuHUua7C', 1),
(19, 'ooi', 'passwordF73C98F5AD312F56B9CAC42449D3712E91FEC55E27FA84A5941F9532E4F11082', 'WD8mside', 1),
(20, 'kitagami', 'passwordDD70C3532A0807738374BE09591D1D61A5E57492A31486B1DD2C539192711643', 'bKuHp2Lz', 0);

INSERT INTO `personal_information` (`id`, `user_id`, `first_name`, `last_name`, `first_phonetic`, `last_phonetic`, `gender`, `email`, `age`, `birthplace`, `hire_date`, `rool`, `tel`) VALUES
(1, 1, '日笠', '育代', 'ヒカサ', 'イクヨ', '男性', 'ikuyo.hikasa@example.com', 29, '石川', '2008-07-01', '平社員', '090-7770-5900'),
(2, 2, '狭間', '恵里佳', 'ハザマ', 'エリカ', '男性', 'erika.hazama@example.com', 28, '香川', '2008-02-01', '部長', '070-5810-6953'),
(3, 3, '森本', '竜也', 'モリモト', 'タツヤ', '女性', 'tatuya.morimoto@example.com', 30, '大阪', '2009-03-16', '平社員', '090-7850-2533'),
(4, 4, '神尾', '啓子', 'カミオ', 'ケイコ', '男性', 'keiko.kamio@example.com', 32, '東京', '2006-04-10', '平社員', '090-4903-2425'),
(5, 5, '山辺', '由起', 'ヤマベ', 'ユキ', '男性', 'yuki.yamabe@example.com', 39, '埼玉', '2007-09-12', '課長', '070-2480-2746'),
(6, 6, '早乙女', '和孝', 'サオトメ', 'カズタカ', '女性', 'kazutaka.saotome@example.com', 42, '山口', '2005-09-08', '平社員', '070-7992-8015'),
(7, 7, '植草', '塁', 'ウエクサ', 'ルイ', '中性', 'rui.uekusa@example.com', 26, '北海道', '2005-10-01', '課長', '080-6561-3696'),
(8, 8, '堀口', '亜希子', 'ホリグチ', 'アキコ', '男性', 'akiko.horiguti@example.com', 29, '大阪', '2010-12-12', '課長', '090-6287-3104'),
(9, 9, '南部', '正幸', 'ナンブ', 'マサユキ', '女性', 'masayuki.nannbu@example.com', 28, '兵庫', '2009-08-12', '平社員', '080-4299-5059'),
(10, 10, '倉上', 'かなみ', 'クラカミ', 'カナミ', '男性', 'kanami.kurakami@example.com', 33, '愛媛', '2010-01-12', '平社員', '090-5746-4801'),
(11, 11, '吉森', '勇希', 'ヨシモリ', 'ユウキ', '女性', 'yuuki.yosimori@example.com', 30, '秋田', '2011-02-01', '平社員', '090-8008-5231'),
(12, 12, '古木', '雄治', 'フルキ', 'ユウジ', '女性', 'yuuji.furuki@example.com', 40, '京都', '2010-04-13', '係長', '090-7305-6987'),
(13, 13, '萱原', '崇子', 'カミハラ', 'タカコ', '男性', 'takako.kamihara@example.com', 37, '山梨', '2009-10-01', '平社員', '080-7870-9789'),
(14, 14, '荒谷', '新吾', 'アラタニ', 'シンゴ', '女性', 'sinngo.aratani@example.com', 36, '東京', '2006-12-01', '平社員', '090-3357-4797'),
(15, 15, '廣橋', '瑛子', 'ヒロハシ', 'アキコ', '男性', 'akiko.hirohasi@example.com', 27, '高知', '2007-03-03', '係長', '080-8604-3774'),
(16, 16, '宮瀬', '優季', 'ミヤセ', 'ユキ', '中性', 'yuki.miyase@example.com', 25, '鳥取', '2005-07-12', '係長', '090-3800-8174'),
(17, 17, '佐山', '文彦', 'サヤマ', 'フミヒコ', '女性', 'fumihiko.sayama@example.com', 40, '和歌山', '2007-05-10', '平社員', '090-6900-8323'),
(18, 18, '末次', '博司', 'スエツグ', 'ヒロシ', '女性', 'hirosi.suetugu@example.com', 43, '福岡', '2008-09-01', '係長', '080-2462-2816'),
(19, 19, '桃井', '晋也', 'モモイ', 'シンヤ', '女性', 'sinnya.momoi@example.com', 30, '沖縄', '2009-11-14', '平社員', '090-7408-0753'),
(20, 20, '成川', '春子', 'ナルサワ', 'ハルコ', '男性', 'haruko.narusawa@example.com', 24, '愛知', '2011-01-20', '平社員', '070-0561-1086');

---- option ----
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `personal_information`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
ALTER TABLE `personal_information`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

COMMIT;