@creditcheck
Feature: Ziraat kredi hesaplama senaryosu

  Scenario: Ziraat kredi hesaplama sayfasi
    Given Ziraat anasayfası açılır
    When Bireysel -> Krediler tıklanır
    Then Hesaplama aracı tıklanır

  Scenario Outline: Ziraat kredi hesaplama
    Given <kredituru> <tutar> <vade> seçilir
    When Hesapla tıklanır
    Then Hesap kontrol edilir

    Examples:
      | kredituru        | tutar  | vade |
      | Taşıt Kredisi    | 100000 | 24   |
      | Tüketici Kredisi | 20000  | 12   |
      | Konut Kredisi    | 350000 | 48   |
