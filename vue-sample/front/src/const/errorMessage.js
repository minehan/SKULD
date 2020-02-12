export default function (code) {
  switch (code) {
    case 'E001':
      return '該当のユーザー名が存在しません'
    case 'E002':
      return 'パスワードが不一致です'
    case 'E003':
      return '未使用'
    case 'E004':
      return 'ユーザー個人情報のデータが０件'
  }
}
