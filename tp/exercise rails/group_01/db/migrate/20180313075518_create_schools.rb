class CreateSchools < ActiveRecord::Migration[5.1]
  def change
    create_table :schools do |t|
      t.string :school_name
      t.integer :school_number

      t.timestamps
    end
  end
end
