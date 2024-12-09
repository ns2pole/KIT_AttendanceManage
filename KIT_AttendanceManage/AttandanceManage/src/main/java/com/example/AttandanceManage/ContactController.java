package com.example.AttandanceManage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    // 連絡先登録フォームを表示
    @GetMapping("/contact")
    public String showContactForm() {
        return "contact";
    }

    // 連絡先登録を処理
    @PostMapping("/contact")
    public String submitContactForm(Contact contact, Model model) {
        // 登録処理（例：コンソール出力）
        System.out.println("電話番号: " + contact.getPhone());
        System.out.println("メールアドレス: " + contact.getEmail());

        // モデルにメッセージを追加
        model.addAttribute("message", "連絡先が登録されました。");

        return "contact";
    }
}
