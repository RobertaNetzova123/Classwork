class CreateSubjects < ActiveRecord::Migration[5.1]
  def change
    create_table :subjects do |t|
      t.string :subject_name
      t.integer :teacher_id

      t.timestamps
    end
  end
end
