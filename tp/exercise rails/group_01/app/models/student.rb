class Student < ApplicationRecord
	validates:school_id, uniqueness: true
	validates:second_name, uniqueness: true
	belongs_to:school
end
