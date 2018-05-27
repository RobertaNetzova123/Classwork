json.extract! teacher, :id, :first_name, :middle_name, :last_name, :title, :subject, :created_at, :updated_at
json.url teacher_url(teacher, format: :json)
