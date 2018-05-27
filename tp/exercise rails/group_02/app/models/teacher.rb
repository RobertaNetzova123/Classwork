class Teacher < ApplicationRecord
	has_many:subjects
	validates :title, uniqueness: true 
end
