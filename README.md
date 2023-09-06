
# Mô tả dự án
Tên dự án: Dự án tìm việc làm
Mục tiêu dự án: Xây dựng một hệ thống tìm kiếm việc làm trực tuyến để giúp người tìm việc và nhà tuyển dụng kết nối với nhau một cách hiệu quả.
# Tài nguyên
1.Link  Front-end (giao diện): https://drive.google.com/drive/u/1/folders/1PDbl8aj-vqaUvXO-jiEC8CcS7bgCUe3e
Trong file giao diện sẽ bao gồm các file và folder cơ bản như sau:

html: hình thành nên bố cục của website.
css: tạo màu sắc, sắp xếp bố cục của website.
js: tạo ra những hành động, thao tác đối với website.
2 . Cơ sở dữ liệu:
đính kèm ở project trong file: sql-scripts



# Các chức năng
Chức năng 1: Trang chủ hiển thị

1. Hiển thị các công ty nổi bật

Ở trang chủ, học viên cần hiển thị những công ty nổi bật trong hệ thống, có thể dựa vào các yếu tố sau: vị trí được ứng tuyển nhiều nhất, nhiều người ứng tuyển nhất, ...

Bạn có thể lựa chọn 1 trong 2 hoặc 3 yếu tố để có thể thể hiện đó công ty nổi bật (Nên ưu tiên kết hợp nhiều điều kiện vào một trong việc làm nổi bật).

File preview

2. Hiển thị các việc làm nổi bật (mới nhất)

Ở trang chủ, học viên cần hiển thị những việc làm nổi bật (mới nhất), về việc làm bạn có thể dựa vào những yếu tố sau: việc làm được ứng tuyển nhiều nhất, việc làm được ưu đãi (lương, kiểu công việc, số lượng, ...), ...

Bạn có thể lựa chọn 1 trong 2 hoặc 3 yếu tố để có thể hiện được việc làm đó nổi bật đó (Nên ưu tiên kết hợp nhiều điều kiện vào một trong việc làm nổi bật).

File preview

3. Hiển thị top danh mục công việc

Ở trang chủ, học viên cần hiển thị thêm ra những danh mục đang đứng đầu trong việc làm tương ứng. Học viên phải xử lý để hiển thị ra top 4 những danh mục công việc đang có số lượng tuyển dụng hoặc số lượng đăng ký nhiều nhất để người dùng hệ thống có thể theo dõi và thao tác tương ứng.

Lưu ý: Nên thống kê những công ty đang có những vị trí việc làm nổi bật, từ đó lọc ra những danh mục tương ứng được tuyển dụng.

File preview

Chức năng 2: Nhà tuyển dụng

1. Đăng nhập hệ thống

Đăng nhập vào hệ thống với tư cách là nhà tuyển dụng để có thể thao tác với một số quyền tương ứng của nhà tuyển dụng. Ví dụ: cập nhật thông tin công ty, quản lý việc đăng tin, quản lý ứng viên, ...). 

Lưu ý: Với form đăng nhập, học viên có thể tạo ra một trang riêng để thực hiện chức năng đăng nhập hoặc có thể hiển thị pop-up ngay màn hình trang chủ để đăng nhập tương ứng.

Thông tin của form đăng nhập sẽ bao gồm 2 thông tin cơ bản là:

Email: đúng định dạng email tương ứng
Mật khẩu


Khi đăng nhập thành công, hãy thông báo cho người dùng hệ thống biết. Và hãy chú ý những lỗi cơ bản như: Sai mật khẩu, sai email, Không đúng email và mật khẩu, ... cũng cần phải hiển thị cho người dùng biết.

2. Đăng ký hệ thống

Về việc đăng ký hệ thống thì bạn sẽ đăng ký dưới hai quyền cơ bản là: nhà tuyển dụng và người tìm việc (người dùng hệ thống). Hệ thống về cơ bản sẽ không có người quản lý hệ thống (Admin), do vai trò của nhà tuyển dụng cũng sẽ khá giống về mặt chức năng của người quản lý hệ thống đang mang. Học viên có thể phát triển nâng cao về quyền cho người quản lý hệ thống cho hệ thống tương lai.

Thông tin của form đăng ký về cơ bản sẽ có 5 thông tin cơ bản là:

Email
Họ và tên
Mật khẩu
Nhập lại mật khẩu
Vai trò: ứng viên (người dùng hệ thống), công ty (nhà tuyển dụng)


Khi đăng ký thành công, hãy thông báo cho người dùng hệ thống biết. Và hãy chú ý những lỗi cơ bản như: email sai định dạng, mật khẩu đúng định dạng (chứa in hoa in thường, có ký tự đặc biệt, có số), ... cũng cần phải hiển thị cho người dùng biết để chỉnh sửa lại.

3. Đăng xuất hệ thống

Đăng xuất hệ thống để kết thúc phiên làm việc của người dùng tương ứng (nhà tuyển dụng hoặc người tìm việc).



4. Cập nhật thông tin cá nhân và công ty

Khi bạn mới đăng nhập thành công với vai trò là công ty (nhà tuyển dụng), bạn sẽ phải có một số thông tin cá nhân và thông tin công ty cần phải thêm và cũng như cần phải cập nhật.



Ví dụ: Khi lựa chọn vào “Fpt Soft” (tên người tuyển dụng - HR) thì sẽ ra một số thông tin cơ bản như: “Hồ Sơ”, “Danh sách bài đăng”, “Đăng xuất”.

Lựa chọn vào “Hồ Sơ” sẽ bao gồm:

Thông tin cá nhân (Thông tin của người tuyển dụng - HR)
Thông tin công ty (Thông tin cơ bản của công ty tương ứng)
Về thông tin cá nhân của nhà tuyển dụng có thể bao gồm những thông tin cơ bản như sau (cần phải ‘validation’ các trường thông tin tương ứng):

Ảnh đại diện
Email cá nhân
Họ và tên
Địa chỉ thường trú
Số điện thoại
Mô tả cơ bản về bản thân


Về thông tin của công ty có thể bao gồm những thông tin cơ bản như sau (cần phải ‘validation’ các trường thông tin tương ứng):

Email
Tên công ty
Địa chỉ thường trú
Số điện thoại của công ty
Mô tả công ty
File preview

5.2.5. Quản lý đăng tin tuyển dụng (Hiển thị các bài đăng)

Hiển thị toàn bộ những tin đăng tuyển dụng của công ty tương ứng. 

Ví dụ: FSoft có 2 công việc cần ứng viên thì sẽ hiển thị ra danh sách bài đăng của nhà tuyển dụng.

Bài đăng sẽ bao gồm những thông tin:
Kiểu công việc
Tên công việc
Công ty
Vị trí tương ứng
Hành động: xem chi tiết, cập nhật, xóa
Ngoài ra, học viên cần phải thực hiện chức năng phân trang tương ứng. CHỈ ĐỂ 5 công việc trang tương ứng để nhà tuyển dụng dễ dàng theo dõi (có thể làm bổ sung phần tìm kiếm tương ứng).

File preview

6. Quản lý đăng tin tuyển dụng (Thêm mới thông tin tuyển dụng)

Bài đăng tuyển dụng chính là cốt lõi của nhà tuyển dụng, giúp cho đăng tin ứng tuyển kịp thời để hiển thị ra trang chủ cho ứng viên và công ty sẽ theo dõi những thông tin tuyển dụng tương ứng.

Thông tin tuyển dụng sẽ bao gồm:

Tiêu đề
Mô tả công việc
Kinh nghiệm
Số người cần tuyển
Địa chỉ công ty
Hạn ứng tuyển
Lương
Loại công việc: thông thường sẽ chọn loại công việc như: fulltime, parttime, freelancer.
Danh mục công việc: các danh mục công việc tương ứng như NodeJS, Java, PHP, ...
Mọi thông tin điền vào cần phải được xác thực tính đúng đắn tương ứng như: số người cần tuyển phải là số, hạn ứng tuyển phải dưới định dạng mm/dd/yyyy, ...

File preview

5.2.7. Quản lý đăng tin tuyển dụng (Chỉnh sửa thông tin tuyển dụng)

Học viên có thể cập nhật thông tin của bài đăng tuyển dụng. Có thể thay đổi một số thông tin quan trọng để thông báo tới ứng viên cũng như hệ thống.

Mọi thông tin khi thay đổi vẫn phải giữ được tính xác thực tính đúng đắn tương ứng như: số người cần tuyển phải là số, hạn ứng tuyển phải dưới định dạng mm/dd/yyyy, ...

File preview

8. Quản lý đăng tin tuyển dụng (Xóa thông tin tuyển dụng)

Khi thực hiện chức năng xóa, cũng phải xác nhận với người tuyển dụng có thực sự muốn xóa bài đăng tương ứng này không.

File preview

6. Quản lý ứng viên (Danh sách ứng viên)

Nhà tuyển dụng có thể xem được danh sách của ứng viên tương ứng.

Lưu ý: Học viên hoàn toàn có thể mô tả chi tiết thông tin của ứng viên như: ứng tuyển vào vị trí tương ứng nào, CV đính kèm, ...

File preview

Ở trong chi tiết công việc tuyển dụng, cần phải hiển thị rõ danh sách của ứng viên tuyển dụng để nhà tuyển dụng có thể thao tác và theo dõi. Nếu không có ai ứng tuyển thì phải hiển thị rõ “Chưa có ứng cử viên nào ứng tuyển”.

File preview

Chức năng 3: Người tìm việc

1. Đăng nhập/Đăng ký/Đăng xuất hệ thống

Về chức năng đăng ký/đăng nhập và đăng xuất của người tìm việc cũng sẽ giống như chức năng đăng ký/đăng nhập và đăng xuất của nhà tuyển dụng.

Lưu ý: Đối với nhà tuyển dụng sẽ có phần gửi email để xác nhận đăng nhập, còn đối với người tìm việc thì sẽ KHÔNG cần phải gửi email xác nhận.

2. Chức năng tìm việc (tìm kiếm theo công việc/ứng cử viên/địa điểm)

Về chức năng tìm kiếm, học viên hoàn toàn có thể tìm kiếm theo 3 cách:

Tìm theo công việc: theo tên công việc tương ứng mà người tìm việc muốn


Tìm theo tên công ty: theo tên công ty mà người tìm việc muốn


Tìm theo địa điểm: tìm theo địa điểm công ty làm việc tương ứng.
Lưu ý: Học viên hoàn toàn chỉ cần có một ô tìm kiếm để tìm kiếm toàn bộ những thông tin trên thành 1 lần tương ứng, đi kèm 3 hoặc 4 điều kiện đi kèm.

3. Cập nhật thông tin của bản thân

Sau khi xác thực tài khoản đăng nhập, học viên cần phải cập nhật thông tin cá nhân cơ bản có bao gồm như:

Ảnh đại diện
Email cá nhân
Họ và tên
Địa chỉ thường trú
Số điện thoại
Mô tả bản thân
Ngoài ra, bạn có thể cập nhật CV của bản thân (định dạng dưới dạng: .pdf)
File preview

4. Chức năng tạo CV (Upload file pdf)

Chức năng tạo CV (Upload file CV dưới dạng .pdf) giúp cho bạn có thể đăng thông tin cá nhân của mình lên cho việc chuẩn bị việc ứng tuyển vào công việc.



5. Ứng tuyển vào công việc

Ở màn hình trang chủ, người tìm việc hoàn toàn có thể thấy những công việc đang ở trạng thái tuyển dụng, lựa chọn vào “Apply Job” để thực hiện ứng tuyển vào công việc tương ứng.



Sau khi lựa chọn ứng tuyển công việc, sẽ hiển thị ra phương thức nộp CV tương ứng, sẽ có 2 phương thức nộp hồ sơ ứng tuyển tương ứng là:

Dùng CV đã cập nhật: người tìm việc đã thực hiện chức năng upload CV cá nhân của mình vào trong hồ sơ cá nhân.


Nộp CV mới: người tìm việc sẽ đính kèm thêm CV mới từ máy tính hoặc điện thoại của cá nhân tương ứng lên hệ thống.


Lưu ý: Hãy thông báo ứng tuyển thành công hay ứng tuyển thất bại ra ngoài màn hình để người dùng hệ thống sẽ biết được trạng thái ứng tuyển tương ứng.

