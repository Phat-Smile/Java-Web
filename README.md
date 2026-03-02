# ProductInofrmation

Ứng dụng web **Java Servlet/JSP** quản lý **Sản phẩm / Danh mục / Tài khoản** (CRUD) kèm **phân quyền theo vai trò** và **đăng nhập**.

> Project được cấu hình theo kiểu **NetBeans + Ant** và chạy trên **Apache Tomcat**.

---

## Tính năng chính

- **Đăng nhập/đăng xuất**
- **Products**
  - Xem danh sách sản phẩm (mọi người có thể xem sau khi login)
  - Thêm / sửa sản phẩm (Staff)
  - Xoá sản phẩm (Manager)
- **Categories**
  - Xem danh sách danh mục (Manager + Staff)
  - Thêm / sửa danh mục (Staff)
  - Xoá danh mục (Manager)
- **Accounts (Admin)**
  - Xem danh sách tài khoản
  - Thêm tài khoản
  - Bật/tắt trạng thái sử dụng tài khoản (isUse)

### Phân quyền (roleInSystem)

Trong code hiện tại quy ước:

- `1` = **Admin**
- `2` = **Manager**
- `0` = **Staff**

(Logic phân quyền được điều hướng qua `MainController`)

---

## Công nghệ sử dụng

- Java Servlet/JSP + JSTL
- JPA (EclipseLink)
- SQL Server (JDBC Driver)
- Bootstrap 5 + FontAwesome

---

## Cấu trúc thư mục

```
ProductInofrmation/
├─ src/java/
│  ├─ controller/               # Servlets (Login/CRUD/Router)
│  └─ services/                 # Entities + JPA Controllers
├─ web/
│  ├─ *.jsp                     # UI pages
│  ├─ navbar.jspf               # Navbar include
│  ├─ images/                   # static images + product images
│  └─ WEB-INF/web.xml           # servlet mapping
└─ src/conf/persistence.xml     # cấu hình DB (JPA)
```

---

## Yêu cầu môi trường

- **JDK 8** (project set `javac.source=1.8`)
- **Apache Tomcat** (NetBeans project properties đang trỏ Tomcat)
- **Microsoft SQL Server**
- **SQL Server JDBC Driver** (ví dụ `sqljdbc4.jar` hoặc bản tương ứng)

> Lưu ý: repo hiện **không kèm file .jar JDBC**, bạn cần tự thêm driver vào:
> - `Tomcat/lib/` (áp dụng cho toàn server), hoặc  
> - `web/WEB-INF/lib/` (kèm theo WAR khi deploy)

---

## Cấu hình Database

### 1) Tạo DB & seed data (khuyến nghị)

Project có sẵn script: `ProductIntroDB.sql`

- Script sẽ `drop database ProductIntro` rồi tạo lại DB, tạo bảng và **insert dữ liệu mẫu** (accounts, categories, products).

Chạy script trên SQL Server trước khi chạy web.

### 2) Cập nhật `persistence.xml`

File: `src/conf/persistence.xml`

Mặc định đang cấu hình:

- URL: `jdbc:sqlserver://localhost:1433;databaseName=ProductIntro`
- user: `sa`
- pass: `12345`
- `javax.persistence.schema-generation.database.action = create`

**Khuyến nghị khi dùng script SQL**: đổi `database.action` từ `create` → `none` (hoặc `update` tuỳ nhu cầu), để tránh JPA tự tạo lại schema làm mất dữ liệu seed.

Ví dụ:

```xml
<property name="javax.persistence.schema-generation.database.action" value="none"/>
```

---

## Chạy project

### Cách 1: Chạy bằng NetBeans (đơn giản nhất)

1. Mở NetBeans → **Open Project** → chọn thư mục `ProductInofrmation/`
2. Cấu hình Tomcat trong NetBeans (Servers)
3. Thêm JDBC driver (SQL Server) vào Libraries / hoặc Tomcat/lib
4. Run project (NetBeans sẽ build & deploy lên Tomcat)

### Cách 2: Build WAR và deploy thủ công

- Build bằng Ant (từ NetBeans hoặc CLI):
  - `ant clean dist`
- Lấy file WAR trong `dist/` và copy vào `Tomcat/webapps/`

---

## Tài khoản demo

Trong `ProductIntroDB.sql` có sẵn:

- **Admin**: `admin` / `abc`
- **Manager**: `manager` / `123`

> Tài khoản chỉ login được khi `isUse = 1`.

---

## Routing / Endpoint

### Router trung tâm

- `MainController` (annotation): `/MainController`
  - Ví dụ:
    - `MainController?action=product-list`
    - `MainController?action=category-add`
    - `MainController?action=account-list`

### Servlet mappings trong `web.xml`

Một số endpoint chính:

- `/login`, `/logout`
- `/list-product`, `/add-product`, `/update-product`, `/delete-product`
- `/list-category`, `/add-category`, `/update-category`, `/delete-category`
- `/list-account`, `/add-account`, `/update-account`, `/delete-account`, `/status-account`

---

## Ghi chú

- `productImage` hiện được lưu dạng **string path** (ví dụ: `/images/sanPham/xxx.jpg`), không có chức năng upload file trong code hiện tại.
- Nếu bạn muốn bổ sung upload ảnh, có thể dùng `multipart/form-data` + lưu file vào `/images/sanPham/` hoặc storage riêng.

---

## License

Tuỳ bạn bổ sung (MIT/Apache-2.0/Private).
