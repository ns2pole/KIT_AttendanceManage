
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // フォームのデフォルトの送信動作を停止

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const messageDiv = document.getElementById('message');

    // 正しいIDとパスワード
    const correctUsername = 'SdjItou';
    const correctPassword = 'itoutowa';

    // バリデーション
    if (username === correctUsername && password === correctPassword) {
        messageDiv.textContent = 'ログイン成功！';
        messageDiv.style.color = 'green';
        // 1秒後に次のページに移動（例: dashboard.html）
        setTimeout(function() {
            window.location.href = 'attendance.html'; // 遷移先のURLを指定
        }, 1000); // 1秒遅延させる
    } else {
        messageDiv.textContent = 'ユーザー名またはパスワードが間違っています。';
        messageDiv.style.color = 'red';
    }
});
