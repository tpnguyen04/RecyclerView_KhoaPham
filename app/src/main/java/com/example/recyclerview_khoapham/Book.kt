package com.example.recyclerview_khoapham

import androidx.annotation.DrawableRes
import java.time.LocalDate
import java.util.Date

class Book(
    @DrawableRes
    var image: Int,
    var name: String,
    var postDate: Date,
    var viewCount: Int,
    var description: String
) {
    companion object {
        fun getListBooks(): List<Book> {
            return mutableListOf<Book>().apply {
                add(Book(R.drawable.image1, "Vượt lười - Liệu trình cho người thiếu động lực", Date(1700413200000), 211, "Làm thế nào để vượt qua sự lười biếng? Có cách nào trị triệt để căn bệnh này không? Chắc hẳn những bạn trẻ thường xuyên gặp phải tình trạng trì trệ..."))
                add(Book(R.drawable.image2, "Hãy yêu đời dẫu đời có trái ngang - Lời nhắn gửi đến bạn một đời hạnh phúc", Date(1700413200000), 180, "Hãy yêu đời dẫu đời có trái ngang” một tập thơ truyền năng lượng tích cực đến người trẻ, dẫu có khó khăn, mệt mỏi, áp lực chỉ hy vọng bạn không..."))
                add(Book(R.drawable.image3, "Tĩnh lặng - Sức mạnh của tĩnh lặng trong thế giới huyên náo", Date(1699808400000), 443, "Tĩnh lặng - sức mạnh của sự tĩnh lặng trong thế giới huyên náo” của thiền sư Thích Nhất Hạnh sẽ giúp chúng ta thay đổi góc nhìn, hướng về bên trong và..."))
                add(Book(R.drawable.image4, "Nghệ thuật tối giản: Có ít đi, sống nhiều hơn", Date(1699808400000), 357, "Nghệ thuật tối giản: Có ít đi, sống nhiều hơn” cuốn sách tổng hợp những triết lý đơn giản giúp bạn giải phóng năng lượng tiêu cực và tập trung vào.."))
                add(Book(R.drawable.image5, "Chỉ cần em mạnh mẽ sẽ có cách đừng lo - Cách người trưởng thành yêu nhau", Date(1699808400000), 258, "Chỉ cần em mạnh mẽ sẽ có cách đừng lo” một cuốn sách giúp chúng ta vượt qua những mệt mỏi trong cuộc sống, xoa dịu trái tim mong manh dễ vỡ của bạn thông..."))
                add(Book(R.drawable.image6, "Chưa kịp lớn đã phải trưởng thành - Những đứa trẻ đang học cách lớn lên", Date(1699462800000), 424, "Chưa kịp lớn đã phải trưởng thành” cuốn sách xoa dịu những vết thương lòng khi chúng ta phải đối diện với hàng tá áp lực mang tên tuổi trưởng thành"))
                add(Book(R.drawable.image7, "Review sách Sống như bông pháo hoa", Date(1686589200000), 5537, "Sống như bông pháo hoa là cuốn sách với mười hai chương sách là mười hai cuộc hành trình để khám phá những góc nhìn mới trả lời cho câu hỏi: “Điều quý giá..."))
                add(Book(R.drawable.image8, "Review sách “Ba người thầy vĩ đại” của tác giả Robin Sharma", Date(1672678800000), 13268, "Cuốn sách “Ba người thầy vĩ đại” là một trong những cuốn sách đang để gối đầu giường, một tác phẩm xuất sắc về việc thay đổi bản thân để trở..."))
                add(Book(R.drawable.image9, "Review sách Đừng cố làm người tốt trong mắt tất cả mọi người", Date(1672678800000), 10511, "Đừng cố làm người tốt trong mắt tất cả mọi người” điều này sẽ rất vô nghĩa. Thế giới có vô vàn kiểu người, có người tốt, người xấu và trong..."))
                add(Book(R.drawable.image10, "Nghệ thuật từ chối - Cách nói không mà vẫn có được đồng thuận", Date(1673370000000), 7925, "Nghệ thuật từ chối cuốn sách giúp bạn chinh phục kỹ năng giao tiếp, giúp bạn biết cách ứng xử sao cho phù hợp với tất cả các mối quan hệ xung quanh."))
            }
        }
    }
}