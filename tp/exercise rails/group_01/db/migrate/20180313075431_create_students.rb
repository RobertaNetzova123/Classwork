class CreateStudents < ActiveRecord::Migration[5.1]
  def change
    create_table :students do |t|
      t.string :first_name
      t.string :second_name
      t.string :email
      t.integer :school_id

      t.timestamps
    end
  end
end
