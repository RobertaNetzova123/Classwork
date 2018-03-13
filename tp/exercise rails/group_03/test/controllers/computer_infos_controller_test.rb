require 'test_helper'

class ComputerInfosControllerTest < ActionDispatch::IntegrationTest
  setup do
    @computer_info = computer_infos(:one)
  end

  test "should get index" do
    get computer_infos_url
    assert_response :success
  end

  test "should get new" do
    get new_computer_info_url
    assert_response :success
  end

  test "should create computer_info" do
    assert_difference('ComputerInfo.count') do
      post computer_infos_url, params: { computer_info: { brand: @computer_info.brand, color: @computer_info.color, processor: @computer_info.processor, room_id: @computer_info.room_id } }
    end

    assert_redirected_to computer_info_url(ComputerInfo.last)
  end

  test "should show computer_info" do
    get computer_info_url(@computer_info)
    assert_response :success
  end

  test "should get edit" do
    get edit_computer_info_url(@computer_info)
    assert_response :success
  end

  test "should update computer_info" do
    patch computer_info_url(@computer_info), params: { computer_info: { brand: @computer_info.brand, color: @computer_info.color, processor: @computer_info.processor, room_id: @computer_info.room_id } }
    assert_redirected_to computer_info_url(@computer_info)
  end

  test "should destroy computer_info" do
    assert_difference('ComputerInfo.count', -1) do
      delete computer_info_url(@computer_info)
    end

    assert_redirected_to computer_infos_url
  end
end
