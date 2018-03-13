class ComputerInfosController < ApplicationController
  before_action :set_computer_info, only: [:show, :edit, :update, :destroy]

  # GET /computer_infos
  # GET /computer_infos.json
  def index
    @computer_infos = ComputerInfo.all
    @rooms = Room.all
  end

  # GET /computer_infos/1
  # GET /computer_infos/1.json
  def show
  end

  # GET /computer_infos/new
  def new
    @computer_info = ComputerInfo.new
  end

  # GET /computer_infos/1/edit
  def edit
  end

  # POST /computer_infos
  # POST /computer_infos.json
  def create
    @computer_info = ComputerInfo.new(computer_info_params)

    respond_to do |format|
      if @computer_info.save
        format.html { redirect_to @computer_info, notice: 'Computer info was successfully created.' }
        format.json { render :show, status: :created, location: @computer_info }
      else
        format.html { render :new }
        format.json { render json: @computer_info.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /computer_infos/1
  # PATCH/PUT /computer_infos/1.json
  def update
    respond_to do |format|
      if @computer_info.update(computer_info_params)
        format.html { redirect_to @computer_info, notice: 'Computer info was successfully updated.' }
        format.json { render :show, status: :ok, location: @computer_info }
      else
        format.html { render :edit }
        format.json { render json: @computer_info.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /computer_infos/1
  # DELETE /computer_infos/1.json
  def destroy
    @computer_info.destroy
    respond_to do |format|
      format.html { redirect_to computer_infos_url, notice: 'Computer info was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_computer_info
      @computer_info = ComputerInfo.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def computer_info_params
      params.require(:computer_info).permit(:color, :brand, :processor, :room_id)
    end
end
